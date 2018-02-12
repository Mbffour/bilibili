package com.cnLive.common.webSocket;

import com.cnLive.common.webSocket.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2018/2/12.
 */

@Controller
@RequestMapping("/client")
public class ClientController {

    @RequestMapping("/zhibo")
    public String livePage(HttpServletRequest request, HttpSession session){
        Users u = new Users();
        LiveRoom room = new LiveRoom(u);


        room.setRoomId("8881");

        //默认没直播


        request.setAttribute("user",u);
        session.setAttribute("user",u);
        request.setAttribute("liveRoom",room);
        return "live";
    }


}
