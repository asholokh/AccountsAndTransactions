package com.bh.transactions.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transactions/", method = RequestMethod.GET)
public class TransactionsRestController {
/*
    @Value("${2fa.enabled}")
    private boolean isTwoFaEnabled;
*/

/*
    @RequestMapping(value = "{login}/{password}", method = RequestMethod.POST)
    public AuthenticationStatus authenticate(@PathVariable String login, @PathVariable String password) {
        Optional<User> user = userService.findUser(login, password);

        if (!user.isPresent()) {
            return AuthenticationStatus.FAILED;
        }
        if (!isTwoFaEnabled) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(login, password);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return AuthenticationStatus.AUTHENTICATED;
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
            return AuthenticationStatus.REQUIRE_TOKEN_CHECK;
        }
    }
*/

}
