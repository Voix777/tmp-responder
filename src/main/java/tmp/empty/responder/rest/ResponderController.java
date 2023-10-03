package tmp.empty.responder.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import static java.util.Objects.isNull;

@RestController
public class ResponderController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private ResponseEntity<List<Object>> getListResponseEntity(@RequestHeader Map<String, String> headerValue, @RequestBody(required = false) JsonNode requestbody) throws JsonProcessingException {
        LOG.info("Header: {}", headerValue);
        LOG.info("Request body: {}", requestbody);
        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, JsonNode> responseBody = new HashMap<>();
        Map<String, Map<String,String>> responseHeaders = new HashMap<>();
        responseHeaders.put("Headers:", headerValue);
        if (isNull(requestbody)) {
            JsonNode emptyBody = mapper.readTree("{\"MSG:\":\"No body was provided\"}");
            responseBody.put("Body: ", emptyBody);
            System.out.println(emptyBody);
        }
        else {
            responseBody.put("Body: ", requestbody);
        }
        List<Object> response = new ArrayList<>();
        response.add(0,responseHeaders);
        response.add(1, responseBody);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(response);
    }

    @PostMapping("/**")
    public ResponseEntity<List<Object>> logPostRequest(@RequestHeader Map<String, String> headerValue, @RequestBody(required = false) JsonNode requestbody) throws InterruptedException, URISyntaxException, IOException {
        return getListResponseEntity(headerValue, requestbody);
    }

    @PatchMapping("/**")
    public ResponseEntity<List<Object>> logPatchRequest(@RequestHeader Map<String, String> headerValue, @RequestBody(required = false) JsonNode requestbody) throws InterruptedException, URISyntaxException, IOException {
        return getListResponseEntity(headerValue, requestbody);
    }

    @PutMapping("/**")
    public ResponseEntity<List<Object>> logPutRequest(@RequestHeader Map<String, String> headerValue, @RequestBody(required = false) JsonNode requestbody) throws InterruptedException, URISyntaxException, IOException {
        return getListResponseEntity(headerValue, requestbody);
    }

    @GetMapping("/**")
    public ResponseEntity<List<Object>> logGetRequest(@RequestHeader Map<String, String> headerValue, @RequestParam() Map<String,String> requestParam) throws InterruptedException, URISyntaxException, IOException {
        LOG.info("Header: {}", headerValue);
        LOG.info("Request params: {}", requestParam);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Map<String,String>> responseHeaders = new HashMap<>();
        responseHeaders.put("Headers:", headerValue);
        List<Object> response = new ArrayList<>();
        response.add(0,responseHeaders);
        response.add(1, requestParam);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(response);
    }
}
