package tmp.empty.responder.rest;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
public class ResponderController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @PostMapping("/responder/api/v1/pendingInventoryChange")
    public ResponseEntity<String> logPostRequest(@RequestHeader Map<String, String> headerValue, @RequestBody JsonNode requestbody) throws InterruptedException, URISyntaxException, IOException {
        LOG.info("Header: {}", headerValue);
        LOG.info("Request body: {}", requestbody);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body("POST received");
    }

    @PatchMapping("/responder/api/v1/pendingInventoryChange")
    public ResponseEntity<String> logPatchRequest(@RequestHeader Map<String, String> headerValue, @RequestBody JsonNode requestbody) throws InterruptedException, URISyntaxException, IOException {
        LOG.info("Header: {}", headerValue);
        LOG.info("Request body: {}", requestbody);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body("PATCH received");
    }

    @PutMapping("/responder/api/v1/pendingInventoryChange")
    public ResponseEntity<String> logPutRequest(@RequestHeader Map<String, String> headerValue, @RequestBody JsonNode requestbody) throws InterruptedException, URISyntaxException, IOException {
        LOG.info("Header: {}", headerValue);;
        LOG.info("Request body: {}", requestbody);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body("PUT received");
    }

    @GetMapping("/responder/api/v1/pendingInventoryChange")
    public ResponseEntity<String> logGetRequest(@RequestHeader Map<String, String> headerValue, @RequestBody JsonNode requestbody) throws InterruptedException, URISyntaxException, IOException {
        LOG.info("Header: {}", headerValue);
        LOG.info("Request body: {}", requestbody);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body("GET received");
    }
}
