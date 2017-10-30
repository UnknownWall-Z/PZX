package com.memory.pzp.base.service.impl;

import com.memory.pzp.base.domain.Mailverify;
import com.memory.pzp.base.domain.Userinfo;
import com.memory.pzp.base.mapper.MailverifyMapper;
import com.memory.pzp.base.service.IUserinfoService;
import com.memory.pzp.base.service.IVerifyPhoneService;
import com.memory.pzp.base.util.BitStatesUtils;
import com.memory.pzp.base.util.Consts;
import com.memory.pzp.base.util.DateUtils;
import com.memory.pzp.base.vo.VerifyPhoneOv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by wall on 2017/9/15.
 */
@Service
public class VerifyPhoneServiceImpl implements IVerifyPhoneService{

//    @Value("${sms.url}")
//    private String url;
//    @Value("${sms.username}")
//    private String username;
//    @Value("${sms.password}")
//    private String password;
//    @Value("${sms.apikey}")
//    private String apikey;


    @Autowired
    private IUserinfoService userinfoService;

    @Autowired
    private MailverifyMapper mailverifyMapper;

    @Override
    public VerifyPhoneOv verifyPhone(VerifyPhoneOv verify,String phoneName,long userId) {
        if(verify==null || DateUtils.interval(verify.getVerifyDate(),new Date())> Consts.INTERVAL){

//            // 创建一个URL对象
//            URL url = new URL(this.url);
//            // 使用url创建一个连接对象
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            // 设置相关属性
//            conn.setRequestMethod("POST");
//            // 设置要输出实体内容
//            conn.setDoOutput(true);
//            // 设置输出的内容
//            StringBuilder sBuilder = new StringBuilder(100).append("username=").append(this.username)
//                    .append("&password=").append(password).append("&apikey=").append(apikey).append("&phoneNumber=")
//                    .append(phoneNumber).append("&content=").append("你收到的验证码为:").append(random)
//                    .append(",请及时使用,有效时间为").append(BidConst.MESSAGE_VAILED_TIME).append("分钟");
//            conn.getOutputStream().write(sBuilder.toString().getBytes());
//            conn.connect();
//            String ret = StreamUtils.copyToString(conn.getInputStream(), Charset.forName("UTF-8"));
//            if (ret.indexOf("success:") == 0) {
//                return null
//            }
            String uuid = UUID.randomUUID().toString().substring(0, 4);
            System.out.println(phoneName+" 您的验证码为:"+""+uuid);
            return new VerifyPhoneOv(phoneName,new Date(),userId,uuid);
        }
        return null;
    }

    @Override
    public boolean bindPhone(VerifyPhoneOv verfiyCode, String phoneNumber, String uuid) {

        if( verfiyCode!=null &&
            phoneNumber.equals(verfiyCode.getPhoneName()) &&
            uuid.equals(verfiyCode.getUuid())
          ){
            Userinfo user = userinfoService.getByUserId(verfiyCode.getUserId());
            if(user.getHasBindPhone()){
                return false;
            }
            user.setBitState(BitStatesUtils.addState(user.getBitState(),BitStatesUtils.OP_BIND_PHONE));
            user.setPhoneNumber(phoneNumber);
            userinfoService.update(user);
            return true;
        }

        return false;
    }

    @Override
    public void sendEmail(String email, long userId) throws Exception{

        String verifyUrl = UUID.randomUUID().toString();
        StringBuilder sb  = new StringBuilder();
        sb.append("<a href='http://localhost/verifyEmail?verifyUrl=")
                .append(verifyUrl).append("'>点击完成绑定~</a>");
        System.out.println(sb.toString());
        mailverifyMapper.insert(new Mailverify(null,userId,new Date(),verifyUrl,email));

    }

    @Override
    public void verifyEmail(String verifyUrl) {

        Mailverify mailverify = mailverifyMapper.selectByRandomCode(verifyUrl);
        if( mailverify!=null &&
            DateUtils.interval(mailverify.getDeadline(),new Date())<Consts.SEND_EMAIL_DAY
          ){
                Userinfo user = userinfoService.getByUserId(mailverify.getUserinfo_id());
                if(!user.getHasBindEmail()){
                    long state = BitStatesUtils.addState(user.getBitState(), BitStatesUtils.OP_BIND_EMAIL);
                    user.setBitState(state);
                    user.setEmail(mailverify.getEmail());
                    userinfoService.update(user);
                    return;
                }

            }
        throw new RuntimeException("绑定失败！");
    }
}
