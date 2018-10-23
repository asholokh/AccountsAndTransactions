package com.bh.accounts.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account/", method = RequestMethod.GET)
public class AccountRestController {
/*
    @Value("${2fa.enabled}")
    private boolean isTwoFaEnabled;
*/

/*
    @RequestMapping(value = "/register/{login}/{password}", method = RequestMethod.POST)
    public String register(@PathVariable String login, @PathVariable String password) {
        User user = userService.register(login, password);
        String encodedSecret = new Base32().encodeToString(user.getSecret().getBytes());

        // This Base32 encode may usually return a string with padding characters - '='.
        // QR generator which is user (zxing) does not recognize strings containing symbols other than alphanumeric
        // So just remove these redundant '=' padding symbols from resulting string
        return encodedSecret.replace("=", "");
    }
*/
}
