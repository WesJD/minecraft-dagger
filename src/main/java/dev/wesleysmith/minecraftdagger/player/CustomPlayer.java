package dev.wesleysmith.minecraftdagger.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Delegate;
import org.bukkit.entity.Player;

import java.time.Instant;

@RequiredArgsConstructor
@Getter
@Setter
public class CustomPlayer implements Player {

    @Delegate private final Player player;
    private final Instant loginTime;
    private int suicideCount;

}
