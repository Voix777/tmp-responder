package tmp.empty.responder.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/digioss")
public class DigiOssController {

  @GetMapping(value = "/logicalResource/{id}", produces = "application/json")
  public ResponseEntity<Object> retrieveLogicalResource(@PathVariable String id,
                                                        @RequestHeader Map<String, String> header) {
    log.info("{}, id = {}", "retrieveLogicalResource", id);
    log.info("Header: {}", header);
    return ResponseEntity.notFound().build();
  }

  @PostMapping(value = "/token", consumes = "application/x-www-form-urlencoded")
  public ResponseEntity<TokenResponse> token(@RequestHeader Map<String, String> headerValue) {
    log.info("{}", "token");
    log.info("Header: {}", headerValue);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return ResponseEntity.ok()
        .headers(headers)
        .body(TokenResponse.builder()
            .accessToken("Some token")
            .expiresIn(86400)
            .build());
  }

  @Builder
  private static class TokenResponse {
    @JsonProperty("access_token")
    private transient String accessToken;

    @JsonProperty("expires_in")
    private transient int expiresIn;
  }
}
