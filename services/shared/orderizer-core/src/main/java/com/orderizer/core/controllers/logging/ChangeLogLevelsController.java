package com.orderizer.core.controllers.logging;

import com.orderizer.core.service.logging.ChangeLogLevelsService;
import com.orderizer.core.models.log.LogLevels;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/logging")
public class ChangeLogLevelsController {

    private final ChangeLogLevelsService changeLogLevelsService;

    public ChangeLogLevelsController(ChangeLogLevelsService changeLogLevelsService) {
        this.changeLogLevelsService = changeLogLevelsService;
    }

    @PostMapping
    public ResponseEntity<Mono<Void>> changeLogLevels(@RequestBody @Valid LogLevels logLevels) {
        return ResponseEntity.ok().body(changeLogLevelsService.changeLogLevels(logLevels));
    }

}
