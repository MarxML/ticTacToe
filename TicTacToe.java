/*
TicTacToe.java

This class holds one constructor method for a game of TicTacToe set in a JFrame.
All the properties are created within the default constructor, however it doesn't
set visible = true, so if using you must do that manually.

This is for a Java GUI project in CSCI 112

Last edited 04/27/2023 by Adam Marx
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.util.Random;

public class TicTacToe implements ActionListener {

    // Properties ***************************************************************
    Random random = new Random();        // Used for deciding who goes first
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();   // Holds a text field that displays title and who's turn it is (NORTH)
    JPanel button_panel = new JPanel();  // Holds the 9 squares in 3x3 format (CENTER)
    JLabel textfield = new JLabel();     // A text field held by title_panel
    JButton[] buttons = new JButton[9];  // Array of 9 squares on the board
    boolean player1_turn;                // If false, it's player 2's turn

    // Default (and only) constructor
    TicTacToe(){

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.getContentPane().setBackground(new Color(59, 57, 57));
        frame.setLayout(new BorderLayout());
        frame.setTitle("TIC-TAC-TOE");

        // Set textfield properties
        textfield.setBackground(new Color(59, 57, 57));
        textfield.setForeground(new Color(143, 103, 159));
        textfield.setFont(new Font("Helvetica",Font.BOLD,80));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        // Set title_panel properties, and attach textfield to it
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,700,100);
        title_panel.add(textfield);

        // Set button_panel properties
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(61, 61, 56));

        // Instantiate each button in buttons[], then add to button_panel
        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Helvetica",Font.BOLD,100));
            buttons[i].setFocusable(false);
            buttons[i].setBackground(new Color(162, 162, 168));
            buttons[i].addActionListener(this);
        } // end for

        // add button_panel and title_panel to the frame
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    } // end TicTacToe()

    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++) {
            if((player1_turn) && (e.getSource()==buttons[i])){
                if(Objects.equals(buttons[i].getText(), "")) {
                    buttons[i].setForeground(new Color(88, 127, 189));
                    buttons[i].setText("X");
                    player1_turn=false;
                    textfield.setText("O turn");
                    check();
                } // end if(buttons[i].getText()=="")
            } // end if((player1_turn) && (e.getSource()==buttons[i]))
            else if((!player1_turn) && (e.getSource()==buttons[i])){
                if(Objects.equals(buttons[i].getText(), "")) {
                    buttons[i].setForeground(new Color(189, 109, 50));
                    buttons[i].setText("O");
                    player1_turn=true;
                    textfield.setText("X turn");
                    check();
                } // end if(buttons[i].getText()=="")
            } // end else if((!player1_turn) && (e.getSource()==buttons[i]))
        } // end for
    } // end public void actionPerformed(ActionEvent e)

    public void firstTurn() {

        if(random.nextInt(2)==0) {
            player1_turn=true;
            textfield.setText("X's turn");
        } // end if
        else {
            player1_turn=false;
            textfield.setText("O's turn");
        } // end else
    }

    // This method checks for win conditions for X or O. As there are only
    // 8 possible solutions for each player, they are simply hard-coded in.
    public void check() {
        //check X win conditions
        if(
                (Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[1].getText(), "X")) &&
                (Objects.equals(buttons[2].getText(), "X"))
        ) {
            xWins(0,1,2);
        } // end if
        if(
                (Objects.equals(buttons[3].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[5].getText(), "X"))
        ) {
            xWins(3,4,5);
        } // end if
        if(
                (Objects.equals(buttons[6].getText(), "X")) &&
                (Objects.equals(buttons[7].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWins(6,7,8);
        }  // end if
        if(
                (Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[3].getText(), "X")) &&
                (Objects.equals(buttons[6].getText(), "X"))
        ) {
            xWins(0,3,6);
        }  // end if
        if(
                (Objects.equals(buttons[1].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[7].getText(), "X"))
        ) {
            xWins(1,4,7);
        }  // end if
        if(
                (Objects.equals(buttons[2].getText(), "X")) &&
                (Objects.equals(buttons[5].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWins(2,5,8);
        } // end if
        if(
                (Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWins(0,4,8);
        } // end if
        if(
                (Objects.equals(buttons[2].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[6].getText(), "X"))
        ) {
            xWins(2,4,6);
        } // end if
        //check O win conditions
        if(
                (Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[1].getText(), "O")) &&
                (Objects.equals(buttons[2].getText(), "O"))
        ) {
            oWins(0,1,2);
        } // end if
        if(
                (Objects.equals(buttons[3].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[5].getText(), "O"))
        ) {
            oWins(3,4,5);
        } // end if
        if(
                (Objects.equals(buttons[6].getText(), "O")) &&
                (Objects.equals(buttons[7].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))
        ) {
            oWins(6,7,8);
        } // end if
        if(
                (Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[3].getText(), "O")) &&
                (Objects.equals(buttons[6].getText(), "O"))
        ) {
            oWins(0,3,6);
        } // end if
        if(
                (Objects.equals(buttons[1].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[7].getText(), "O"))
        ) {
            oWins(1,4,7);
        } // end if
        if(
                (Objects.equals(buttons[2].getText(), "O")) &&
                (Objects.equals(buttons[5].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))
        ) {
            oWins(2,5,8);
        } // end if
        if(
                (Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))
        ) {
            oWins(0,4,8);
        } // end if
        if(
                (Objects.equals(buttons[2].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[6].getText(), "O"))
        ) {
            oWins(2,4,6);
        } // end if
    } // end check

    public void xWins(int a,int b,int c) {
        buttons[a].setBackground(new Color(89, 143, 44));
        buttons[b].setBackground(new Color(89, 143, 44));
        buttons[c].setBackground(new Color(89, 143, 44));

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        } // end for
        textfield.setForeground(new Color(88, 127, 189));
        textfield.setText("X wins!");
    } // end xWins()
    public void oWins(int a,int b,int c) {
        buttons[a].setBackground(new Color(89, 143, 44));
        buttons[b].setBackground(new Color(89, 143, 44));
        buttons[c].setBackground(new Color(89, 143, 44));

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        } // end for
        textfield.setForeground(new Color(189, 110, 50));
        textfield.setText("O wins");
    } // end oWins()
} // end class
