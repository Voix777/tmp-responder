package tmp.empty.responder.rest;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/ems-pod-proxy/api/v1")
public class EmsPodProxyController {

    @PostMapping("/commands/execution/logicalResource/{logicalResourceId}/commands")
    public ResponseEntity<List<Object>> commandExecution(@RequestHeader Map<String, String> headerValue,
                                                         @PathVariable String logicalResourceId,
                                                         @RequestBody(required = false) JsonNode requestbody) {
        log.info("{}, id = {}", "commandExecution", logicalResourceId);
        log.info("Header: {}", headerValue);
        log.info("Request body: {}", requestbody);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).build();
    }
}
