package com.sye010.datagridtest;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import jakarta.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @Autowired
    private RemoteCacheManager cacheManager;

    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String password, HttpServletRequest request) {
        // 여기서 실제로 사용자 인증을 수행할 수 있습니다.
        // 이 예제에서는 단순히 메시지를 반환합니다.
        RemoteCache<String, Object> cache = cacheManager.getCache("KHAN_SESSION_LOGIN");
        cache.put(request.getSession().getId(), id);
        return "login";
    }

}
