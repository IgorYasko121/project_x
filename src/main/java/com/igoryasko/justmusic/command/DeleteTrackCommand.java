package com.igoryasko.justmusic.command;

import com.igoryasko.justmusic.exception.CommandException;
import com.igoryasko.justmusic.exception.ServiceException;
import com.igoryasko.justmusic.service.TrackService;
import com.igoryasko.justmusic.util.PageConstant;
import com.igoryasko.justmusic.util.ParameterConstant;
import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * The {@code DeleteTrackCommand} class deletes track from database.
 * @author Igor Yasko on 2019-07-19.
 */
@Log4j2
public class DeleteTrackCommand implements Command {

    private TrackService service;

    public DeleteTrackCommand(TrackService receiver) {
        this.service = receiver;
    }

    @Override
    public Optional<CommandResult> execute(HttpServletRequest request) throws CommandException {
        CommandResult router = new CommandResult();
        long trackId = Long.parseLong(request.getParameter(ParameterConstant.TRACK_ID));
        try {
            service.deleteTrack(trackId);
        } catch (ServiceException e) {
            log.error("ServiceException :" + e);
            throw new CommandException("Command execute fail" + e);
        }
        router.setRoute(CommandResult.RouteType.REDIRECT);
        router.setPagePath(PageConstant.PATH_ADMIN);
        return Optional.of(router);
    }

}
