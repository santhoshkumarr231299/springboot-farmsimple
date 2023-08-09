package com.farmsimple.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class JsonResponse {
    @Setter
    @Getter
    class Response {
        Response(String status, String message, Object data) {
            this.status = status;
            this.message = message;
            this.data = data;
        }
        private String status;
        private String message;
        private Object data;
    }
    public ResponseEntity createJsonResponseSuccess(Object model, String message) {
        return new ResponseEntity( new Response("success", message, model), HttpStatus.OK);
    }
    public ResponseEntity createJsonResponseFailure(Object model, String message) {
        return new ResponseEntity( new Response("failed", message, model), HttpStatus.OK);
    }
    public ResponseEntity createJsonResponseError(String message) {
        return new ResponseEntity( new Response("error", message, null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
