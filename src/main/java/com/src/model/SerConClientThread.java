package com.src.model;

import com.src.common.Message;
import com.src.common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;


/**
 * 功能
 *
 * @author caojianbang
 * @date 20/12/2021 23:33
 */
public class SerConClientThread extends Thread {
    Socket s;


    public SerConClientThread(Socket s) {
        this.s = s;
    }

    public void notifyOther(String i) {
        HashMap hm =ManageClientThread.hm;
        //逐个通知
        Iterator it = hm.keySet().iterator();
        while(it.hasNext()){
            //在线人员
            String online = it.next().toString();
            //创建信息包
            Message m = new Message();
            m.setCon(i);
            m.setMesType(MessageType.message_get_onlineFriend);
            m.setReceiver(online);
            //获得线程，然后通知
            try {
                m.setReceiver(online);
                ObjectOutputStream ous = new ObjectOutputStream(ManageClientThread.getClientThread(online).s.getOutputStream());
                ous.writeObject(m);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                //从对象输入流获取
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Message m = (Message) ois.readObject();
                if (m.getMesType().equals(MessageType.message_comm_mes)) {
                    SerConClientThread serConClientThread = ManageClientThread.getClientThread(m.getReceiver());
                    ObjectOutputStream oos = new ObjectOutputStream(serConClientThread.s.getOutputStream());
                    oos.writeObject(m);
                } else if (m.getMesType().equals(MessageType.message_get_onlineFriend)) {
                    //获取所有用户
                    String res = ManageClientThread.getAllOlineUserId();
                    //做一个信息包
                    Message m2 = new Message();
                    m2.setMesType(MessageType.message_get_onlineFriend);
                    m2.setReceiver(m.getSender());
                    m2.setCon(res);
                    //发送给客户
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    oos.writeObject(m2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }

        }
    }
}
