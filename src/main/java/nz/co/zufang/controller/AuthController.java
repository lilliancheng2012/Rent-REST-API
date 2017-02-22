package nz.co.zufang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nz.co.zufang.model.BasicUserLogin;
import nz.co.zufang.model.CerberusUser;
import nz.co.zufang.service.UserService;
import nz.co.zufang.spec.TokenUtils;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserService userService;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody BasicUserLogin userLogin, Device device) {

		// Perform the authentication
		Authentication authentication = this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userLogin.getUserName(), userLogin.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Reload password post-authentication so we can generate token
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(userLogin.getUserName());
		String token = TokenUtils.generateToken(userDetails, device);

		// GenericResponse response =
		// userService.authentication(userLogin.getUserName(),
		// userLogin.getPassword());
	    return ResponseEntity.ok(new AuthResponse(token));
	}


	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	public ResponseEntity<?> authenticationRequest(HttpServletRequest request) {
		String token = request.getHeader("X-Auth-Token");
		String username = TokenUtils.getUsernameFromToken(token);
		CerberusUser user = (CerberusUser) this.userDetailsService.loadUserByUsername(username);
		if (TokenUtils.canTokenBeRefreshed(token, user.getLastPasswordReset())) {
			String refreshedToken = TokenUtils.refreshToken(token);
			return ResponseEntity.ok(new AuthResponse(refreshedToken));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

}
