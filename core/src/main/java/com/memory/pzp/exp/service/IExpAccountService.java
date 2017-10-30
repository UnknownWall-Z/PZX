package com.memory.pzp.exp.service;

import com.memory.pzp.exp.domain.ExpAccount;
import lombok.Getter;

/**
 * Created by wall on 2017/9/24.
 */
public interface IExpAccountService {

    void insert(long userId);

    ExpAccount getByUserId(long id);

    /***
     * 乐观锁
     * @param expAccount
     */
    void update(ExpAccount expAccount);

    /***
     * 有效期
     */
    @Getter
    class LastTime{
        private int amount;
        private LastTimeUnit unit;
        public LastTime(int amount,LastTimeUnit unit){
            this.amount = amount;
            this.unit=unit;
        }
    }

    /***
     * 持续时间单位
     */
    enum LastTimeUnit{
        DAY,MONTH,YEAR
    }

}
