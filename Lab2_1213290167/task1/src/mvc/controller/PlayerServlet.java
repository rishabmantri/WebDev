package mvc.controller;

import mvc.model.Guess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class PlayerServlet extends HttpServlet {
    String[] suspects = {"Miss Scarlet", "Professor Plum", "Mrs. Peacock", "Reverend Green", "Colonel Mustard", "Mrs. White"};
    String[] rooms = {"Kitchen", "Ballroom", "Conservatory", "Dining room", "Lounge", "Hall", "Study", "Library", "Billiard Room"};
    String[] weapons = {"Candlestick", "Dagger", "Lead pipe", "Revolver", "Rope", "Spanner"};
    List<java.lang.String> weaponlist = Arrays.asList(weapons);

    List<String> playerRooms;
    List<String> playerSuspects;
    List<String> playerWeapons;
    List<String> playerRoomsList;
    List<String> PlayerSuspectsList;
    List<String> playerWeaponsList;

    List<String> computerRooms;
    List<String> computerSuspects;
    List<String> computerWeapons;

    String[] winningSecret = new String[3];

    // Use doGet when game is ongoing. Redirect user to this servlet by a GET request after the user has took turn to
    // guess
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        playerRooms = (ArrayList<String>) session.getAttribute("playerRoomsList");
        playerSuspects = (ArrayList<String>) session.getAttribute("playerSuspectsList");
        playerWeapons = (ArrayList<String>) session.getAttribute("playerWeaponsList");
        req.getRequestDispatcher("/player.jsp").forward(req, resp);

   }


    // Use doPost to start a new game. When user enters name, submit the form to post and create new session
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Creates a new session if one does not exist
        HttpSession session = req.getSession(true);
        session.setAttribute("playerName", req.getParameter("name"));

        if (session.isNew()){
            playerRooms = new ArrayList<>();
            playerSuspects = new ArrayList<>();
            playerWeapons = new ArrayList<>();
            playerRoomsList = new ArrayList<>();
            PlayerSuspectsList = new ArrayList<>();
            playerWeaponsList = new ArrayList<>();

            computerRooms = new ArrayList<>();
            computerSuspects = new ArrayList<>();
            computerWeapons = new ArrayList<>();

            Random r = new Random();
            Guess winningSecret = new Guess(suspects[r.nextInt(suspects.length)],
                    weapons[r.nextInt(weapons.length)],
                    rooms[r.nextInt(rooms.length)]);

            for(int i = 0;i<suspects.length;i++){
                PlayerSuspectsList.add(suspects[i]);
                if(winningSecret.suspect.equals(suspects[i])){
                    playerSuspects.add(suspects[i]);
                    computerSuspects.add(suspects[i]);
                } else if(i%2 == 0)
                    playerSuspects.add(suspects[i]);
                else
                    computerSuspects.add(suspects[i]);
            }
            for(int i = 0;i<rooms.length;i++){
                playerRoomsList.add(rooms[i]);
                if(winningSecret.room.equals(rooms[i])){
                    playerRooms.add(rooms[i]);
                    computerRooms.add(rooms[i]);
                }else if(i%2 == 0)
                    playerRooms.add(rooms[i]);
                else
                    computerRooms.add(rooms[i]);
            }
            for(int i = 0;i<weapons.length;i++){
                playerWeaponsList.add(weapons[i]);
                if(winningSecret.weapon.equals(weapons[i])){
                    playerWeapons.add(weapons[i]);
                    computerWeapons.add(weapons[i]);
                }else if(i%2 == 0)
                    playerWeapons.add(weapons[i]);
                else
                    playerWeapons.add(weapons[i]);
            }


            System.out.println("Winning Secret " + winningSecret);
            session.setAttribute("playerRoomsList", playerRooms);
            session.setAttribute("computerRoomsList", computerRooms);
            session.setAttribute("playerSuspectsList", playerSuspects);
            session.setAttribute("computerSuspectsList", computerSuspects);
            session.setAttribute("playerWeaponsList", playerWeapons);
            session.setAttribute("computerWeaponsList", computerWeapons);
            session.setAttribute("winningSecret", winningSecret);
            session.setAttribute("roomlist", playerRoomsList);
            session.setAttribute("suspectslist", PlayerSuspectsList);
            session.setAttribute("weaponlist", playerWeaponsList);
        }
        req.getRequestDispatcher("/player.jsp").forward(req, resp);

    }
}
