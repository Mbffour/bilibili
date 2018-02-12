package com.cnLive.common.webSocket;

import com.cnLive.common.webSocket.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2018/2/11.
 */
@Controller
@RequestMapping("/text")
public class WebSocketController {

    @RequestMapping("/zhubo")
    public String livePage(HttpServletRequest request, HttpSession session){
        Users u = new Users();
        u.setRoomId(8881);
        u.setUserId("6661");
        u.setUserName("测试员1号");
        u.setUserPassword("123");
        LiveRoom room = new LiveRoom(u);

        room.setLiverId("6661");
        room.setRoomId("8881");
        room.setLiverName("测试员1.1号");
        //默认没直播


        request.setAttribute("user",u);
        session.setAttribute("user",u);
        request.setAttribute("liveRoom",room);
        return "live";
    }


}
