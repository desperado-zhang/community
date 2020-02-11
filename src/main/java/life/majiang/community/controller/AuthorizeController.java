package life.majiang.community.controller;

import life.majiang.community.Provider.GithubProvider;
import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.plaf.synth.SynthStyle;
import java.security.AccessControlContext;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    private Object AccessTokenDTO;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String getClientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(getClientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}


