package ua.training.vitascherry.controller.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.GetCommandMap;
import ua.training.vitascherry.controller.command.PostCommandMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.vitascherry.controller.util.RequestMapper.extractCommand;

public class MainServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(MainServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("HTTP GET {}", req.getRequestURL());
        Command command = extractCommand(req, GetCommandMap.getInstance());
        String responsePage = command.execute(req).getPage();
        logger.info("Response JSP page: {}", responsePage);
        req.getRequestDispatcher(responsePage).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("HTTP POST {}", req.getRequestURL());
        Command command = extractCommand(req, PostCommandMap.getInstance());
        String responsePage = command.execute(req).getPage();
        logger.info("Response JSP page: {}", responsePage);
        req.getRequestDispatcher(responsePage).forward(req, resp);
    }
}
