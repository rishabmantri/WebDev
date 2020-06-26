package mvc.controller;

import mvc.model.Guess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressWarnings({ "unchecked", "serial" })
public class GuessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  	resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session == null){
            System.out.println("Null session found in GuessServlet doPost");
            resp.sendRedirect(resp.encodeRedirectURL("/"));
            return;
        }

        // Create a new guess object which would represent the current guess the player has made
        Guess playerGuess = new Guess(req.getParameter("suspect"),
                req.getParameter("weapon"),
                req.getParameter("room"));

        String s= "";
        session.setAttribute("playerguess", s);
        String c= "";
        session.setAttribute("computerGuess", c);
        String cr= "";
        session.setAttribute("computerGuessR", cr);


        Guess winningSecret = (Guess) session.getAttribute("winningSecret");
        System.out.println("Winning Secret " + winningSecret);

        // Linked List to maintain the history of guesses in order
		LinkedList<Guess> guessHistory = (LinkedList<Guess>) session.getAttribute("guessHistory");
        if(guessHistory == null)
            guessHistory = new LinkedList<Guess>();

        // Compare the current player guess with guesses in the history to check for a duplicate guess
        if(guessHistory.contains(playerGuess)){
            s= "You've already made the " + playerGuess.toString() +". Please try again";
            session.setAttribute("playerguess", s);
            req.getRequestDispatcher("/guess.jsp").forward(req, resp);
            return;
        }

        // If not duplicate, add the current guess to the history
        guessHistory.add(playerGuess);
        session.setAttribute("guessHistory", guessHistory);


        // Check if the current guess is the winning guess
        if(playerGuess.equals(winningSecret)) {
            s= "Your " + playerGuess.toString() +". was correct. You win!";
            session.setAttribute("playerguess", s);
//            session.invalidate();
        }

        // Otherwise respond that the guess and incorrect and display one component of the guess which is incorrect
        else {
            s= "Your " + playerGuess.toString() +". was incorrect. You guessed " + playerGuess.whichIsWrong(winningSecret).toString() +" incorrectly. Please try again";
            session.setAttribute("playerguess", s);

            List<String> computerRooms = (List<String>) session.getAttribute("computerRoomsList");
            List<String> computerSuspects = (List<String>) session.getAttribute("computerSuspectsList");
            List<String> computerWeapons = (List<String>) session.getAttribute("computerWeaponsList");

            // Randomly generate a computer guess and keep generating until the guess is unique by checking
            // against history
            Guess computerGuess = new Guess();
            Random r = new Random();
            do {
                computerGuess.room = computerRooms.get(r.nextInt(computerRooms.size()));
                computerGuess.weapon = computerWeapons.get(r.nextInt(computerWeapons.size()));
                computerGuess.suspect = computerSuspects.get(r.nextInt(computerSuspects.size()));

            }while (guessHistory.contains(computerGuess));
            guessHistory.add(computerGuess);
            session.setAttribute("guessHistory", guessHistory);
            c= "Computer's " + computerGuess.toString() ;
            session.setAttribute("computerGuess", c);

            // If computer's guess is correct. Responds back with a message and ends the game
            if(computerGuess.equals(winningSecret)){
                cr= "Computer guess is correct. Computer wins!" ;
                session.setAttribute("computerGuessR", cr);
//                session.invalidate();
            }

            // Otherwise respond by telling the user the computer guess was incorrect and display one incorrect
            // component of the guess
            else{
                cr= "Computer guess is incorrect. Computer guessed " + computerGuess.whichIsWrong(winningSecret).toString() + " incorrectly" ;
                session.setAttribute("computerGuessR", cr);
                req.getRequestDispatcher("/guess.jsp").forward(req, resp);
            }
            req.getRequestDispatcher("/guess1.jsp").forward(req, resp);
        }


    }
}
