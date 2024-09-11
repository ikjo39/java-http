package com.techcourse.controller;

import com.techcourse.service.UserService;
import java.net.URI;
import org.apache.coyote.http11.request.HttpRequest;
import org.apache.coyote.http11.request.RequestBody;
import org.apache.coyote.http11.response.HttpResponse;

public class RegisterController extends AbstractController {

    private static final URI REDIRECT_URI = URI.create("/index.html");
    private static final URI UNAUTHORIZED_URI = URI.create("/401.html");

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doPost(HttpRequest request, HttpResponse response) {
        try {
            RequestBody body = request.getBody();
            userService.create(body.getParameters());
            response.sendRedirect(REDIRECT_URI.getPath());
        } catch (IllegalArgumentException e) {
            response.sendRedirect(UNAUTHORIZED_URI.getPath());
        }
    }
}
