package es.nextdigital.atm.card.apirest;


import es.nextdigital.atm.card.application.ActivateCardCommand;
import es.nextdigital.atm.card.application.ChangePinCommand;
import es.nextdigital.atm.card.shared.cqrs.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CommandBus commandBus;

    @PatchMapping("/{id}/activate")
    public ResponseEntity<Void> activateCard(@PathVariable Long id) {
        final var command = new ActivateCardCommand(id);
        commandBus.execute(command);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/change-pin")
    public ResponseEntity<Void> changePin(@PathVariable Long id, @RequestBody Integer pin) {
        final var command = new ChangePinCommand(id, pin);
        commandBus.execute(command);
        return ResponseEntity.noContent().build();
    }


}
