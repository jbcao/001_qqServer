package com.src.common;

/**
 * 功能
 *
 * @author caojianbang
 * @date 20/12/2021 13:11
 */
public interface MessageType {
    String message_succeed="1";//登陆成功
    String message_login_fail = "2";//登陆失败
    String message_comm_mes="3";//普通消息包
    String message_get_onlineFriend="4";
    String message_ret_onlineFriend = "5";
}
