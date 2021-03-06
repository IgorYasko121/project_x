package com.igoryasko.justmusic.command;

import lombok.extern.log4j.Log4j2;

import java.util.Optional;

/**
 * The {@code ActionFactory} defines command from request parameter.
 * @author Igor Yasko on 2019-07-19.
 */
@Log4j2
public class ActionFactory {

    public static Optional<Command> defineCommand(String commandName) {
        Optional<Command> current = Optional.empty();
        if (commandName == null) {
            return current;
        }
        CommandType type;
        try {
            type = CommandType.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException e) {
            log.error("IllegalArgumentException :" + e);
            log.warn("Unknown command");
            return current;
        }
        return Optional.of(type.getCommand());
    }

}
