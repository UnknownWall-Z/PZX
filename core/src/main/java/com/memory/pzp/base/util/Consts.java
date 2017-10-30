package com.memory.pzp.base.util;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by wall on 2017/9/14.
 */
public class Consts {
    /***
     *  显示精度
     */
    public static final int DISPLAY_SCALE = 2;
    /***
     *  储存精度
     */
    public static final int STORE_SCALE = 4;
    /***
     * 计算精度
     */
    public static final int CAL_SCALE = 8;
    /***
     * 信用额度初始化
     */
    public static final BigDecimal DEFALUT_BORROW_LIMIT = new BigDecimal("3000.0000");
    /***
     * 系统中的0
     */
    public static final BigDecimal ZERO = new BigDecimal("0.0000");

    /**
     * 发送手机验证的间隔时间
     */
    public static final long INTERVAL = 9;

    public static final long SEND_EMAIL_DAY =24*5;

    /**
     * 文件上次路径
     */
    public static final String PUBLIC_PATH="E:/Z/Codes/IdeaApps/p2p/upload";

    /**
     * 最低信用借款的风控材料分数
     */
    public static final int CREDIT_BORROW_SCORE = 30;

    // --------------------还款类型---------------------------
    public final static int RETURN_TYPE_MONTH_INTEREST_PRINCIPAL = 0; // 还款方式
    // 按月分期还款(等额本息)
    public final static int RETURN_TYPE_MONTH_INTEREST = 1; // 还款方式
    // 按月到期还款(每月还利息,到期还本息)
    // ---------------------标的类型--------------------------
    public final static int BIDREQUEST_TYPE_NORMAL = 0; // 普通信用标
    public final static byte EXPERIENCE_MONEY_TYPE= 1; // 活动体验标

    // ---------------------借款状态---------------------------
    public final static int BIDREQUEST_STATE_PUBLISH_PENDING = 0; // 待发布
    public final static int BIDREQUEST_STATE_BIDDING = 1; // 招标中
    public final static int BIDREQUEST_STATE_UNDO = 2; // 已撤销
    public final static int BIDREQUEST_STATE_BIDDING_OVERDUE = 3; // 流标
    public final static int BIDREQUEST_STATE_APPROVE_PENDING_1 = 4; // 满标1审
    public final static int BIDREQUEST_STATE_APPROVE_PENDING_2 = 5; // 满标2审
    public final static int BIDREQUEST_STATE_REJECTED = 6; // 满标审核被拒绝
    public final static int BIDREQUEST_STATE_PAYING_BACK = 7; // 还款中
    public final static int BIDREQUEST_STATE_COMPLETE_PAY_BACK = 8; // 已还清
    public final static int BIDREQUEST_STATE_PAY_BACK_OVERDUE = 9; // 逾期
    public final static int BIDREQUEST_STATE_PUBLISH_REFUSE = 10; // 发标审核拒绝状态
    public final static byte EXPERIENCE_MONEY_PUBLISH = 11; // 活动进发布状态

    public static final BigDecimal SMALLEST_BID_AMOUNT = new BigDecimal("50.0000");// 系统规定的最小投标金额
    public static final BigDecimal SMALLEST_BIDREQUEST_AMOUNT = new BigDecimal("500.0000");// 系统规定的最小借款金额
    public static final BigDecimal SMALLEST_CURRENT_RATE = new BigDecimal("5.0000");// 系统最小借款利息
    public static final BigDecimal MAX_CURRENT_RATE = new BigDecimal("20.0000");// 系统最大借款利息

    /** =============================账户流水类型================================ */
    public final static byte ACCOUNT_ACTIONTYPE_RECHARGE_OFFLINE = 0;// 资金流水类别：线下充值
    // 可用余额增加
    public final static byte ACCOUNT_ACTIONTYPE_WITHDRAW = 1;// 资金流水类别：提现成功
    // 冻结金额减少
    public final static byte ACCOUNT_ACTIONTYPE_BIDREQUEST_SUCCESSFUL = 2;// 资金流水类别：成功借款
    // 可用余额增加
    public final static byte ACCOUNT_ACTIONTYPE_BID_SUCCESSFUL = 3;// 资金流水类别：成功投标
    // 冻结金额减少
    public final static byte ACCOUNT_ACTIONTYPE_RETURN_MONEY = 4;// 资金流水类别：还款
    // 可用余额减少
    public final static byte ACCOUNT_ACTIONTYPE_CALLBACK_MONEY = 5;// 资金流水类别：回款
    // 可用余额增加
    public final static byte ACCOUNT_ACTIONTYPE_CHARGE = 6;// 资金流水类别：支付平台管理费
    // 可用余额减少
    public final static byte ACCOUNT_ACTIONTYPE_INTEREST_SHARE = 7;// 资金流水类别：利息管理费
    // 可用余额减少
    public final static byte ACCOUNT_ACTIONTYPE_WITHDRAW_MANAGE_CHARGE = 8;// 资金流水类别：提现手续费
    // 冻结金额减少
    public final static byte ACCOUNT_ACTIONTYPE_RECHARGE_CHARGE = 9;// 资金流水类别：充值手续费
    // 可用余额减少
    public final static byte ACCOUNT_ACTIONTYPE_BID_FREEZED = 10;// 资金流水类别：投标冻结金额
    // 冻结金额增加 可用余额减少
    public final static byte ACCOUNT_ACTIONTYPE_BID_UNFREEZED = 11;// 资金流水类别：取消投标冻结金额
    // 标审核失败
    // 冻结金额减少
    // 可用余额增加
    public final static int ACCOUNT_ACTIONTYPE_WITHDRAW_FREEZED = 12;// 资金流水类别：提现申请冻结金额
    // 冻结金额增加
    // 可用余额减少
    public final static int ACCOUNT_ACTIONTYPE_WITHDRAW_UNFREEZED = 13;// 资金流水类别:提现申请失败取消冻结金额
    // 冻结金额减少
    // 可用余额增加
    public final static byte EXPACCOUNT_ACTIONTYPE_BID_FREEZED = 14;// 资金流水类别:提现申请失败取消冻结金额
    //=========================================活动金========================
    public final static BigDecimal EXP_REGISTER_MONEY = new BigDecimal("2000");//注册送的活动金
    public final static BigDecimal EXP_DRAW_MONEY= new BigDecimal
            (ThreadLocalRandom.current().nextInt(300,1000));// 抽奖获得的活动金

    //=========================================活动金类型========================
    public final static byte EXP_REGISTER_TYPE = 0; // 注册活动金


    public static final String getbidrequeststatedisplay(byte bidRequestState) {
        switch (bidRequestState) {
            case BIDREQUEST_STATE_PUBLISH_PENDING:
                return "待发布";
            case BIDREQUEST_STATE_BIDDING:
                return "招标中";
            case BIDREQUEST_STATE_UNDO:
                return "已撤销";
            case BIDREQUEST_STATE_BIDDING_OVERDUE:
                return "流标";
            case BIDREQUEST_STATE_APPROVE_PENDING_1:
                return "满标x审";
            case BIDREQUEST_STATE_REJECTED:
                return "满标审核被拒";
            case BIDREQUEST_STATE_PAYING_BACK:
                return "还款中";
            case BIDREQUEST_STATE_COMPLETE_PAY_BACK:
                return "完成";
            case BIDREQUEST_STATE_PAY_BACK_OVERDUE:
                return "逾期";
            case BIDREQUEST_STATE_PUBLISH_REFUSE:
                return "发标拒绝";
            case EXPERIENCE_MONEY_PUBLISH:
                return "活动金待发布";
            default:
                return "";
        }
    }
}
