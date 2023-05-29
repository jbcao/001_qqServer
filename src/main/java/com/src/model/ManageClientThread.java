package com.src.model;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 功能
 *
 * @author caojianbang
 * @date 20/12/2021 23:35
 */
public class ManageClientThread {
    public static HashMap hm = new HashMap<String,SerConClientThread>();
    public static void addClientThread(String uId,SerConClientThread scct){
        hm.put(uId,scct);
    }
    public static SerConClientThread getClientThread(String uId){
        return (SerConClientThread) hm.get(uId);
    }
    public static String getAllOlineUserId(){
        Iterator it =hm.keySet().iterator();
        String res = "";
        while(it.hasNext()){
            res+=it.next().toString()+" ";
        }
        return res;
    }
}
