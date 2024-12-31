package com.example.tictactoe;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int click = 0;
    int clickx = 0;
    int clicko = 0;

    TextView[][] board = new TextView[3][3]; // 2D array for the game board
    Button btn_playAgain, btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize the board TextViews using a 2D array
        board[0][0] = findViewById(R.id.tv_1);
        board[0][1] = findViewById(R.id.tv_2);
        board[0][2] = findViewById(R.id.tv_3);
        board[1][0] = findViewById(R.id.tv_4);
        board[1][1] = findViewById(R.id.tv_5);
        board[1][2] = findViewById(R.id.tv_6);
        board[2][0] = findViewById(R.id.tv_7);
        board[2][1] = findViewById(R.id.tv_8);
        board[2][2] = findViewById(R.id.tv_9);

        btn_exit = findViewById(R.id.exit);
        btn_playAgain = findViewById(R.id.again);

        // Set up the OnClickListener for each cell
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                final int r = row;
                final int c = col;
                board[row][col].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (click % 2 == 0 && clickx < 4) {
                            board[r][c].setText("X");
                            clickx++;
                            click++;
                        } else if (click % 2 != 0 && clicko < 4) {
                            board[r][c].setText("O");
                            clicko++;
                            click++;
                        } else {
                            return;
                        }
                        checkWinner();
                    }
                });
            }
        }

        // Exit button
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        // Play again button
        btn_playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Reset the board
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        board[row][col].setText("");
                    }
                }

                clicko = 0;
                clickx = 0;
            }
        });
    }

    public void checkWinner() {
        // Check for winning conditions (rows, columns, diagonals)
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0].getText().toString().equals(board[row][1].getText().toString()) &&
                    board[row][1].getText().toString().equals(board[row][2].getText().toString()) &&
                    !board[row][0].getText().toString().equals("")) {
                if (board[row][0].getText().toString().equals("X")) {
                    toastplayero_two();
                } else {
                    toastplayero_one();
                }
                return;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++)


        {
            if (board[0][col].getText().toString().equals(board[1][col].getText().toString()) &&
                    board[1][col].getText().toString().equals(board[2][col].getText().toString()) &&
                    !board[0][col].getText().toString().isEmpty())

            {
                if (board[0][col].getText().toString().equals("X")) {
                    toastplayero_two();
                } else {
                    toastplayero_one();
                }
                return;
            }


        }



        // Check diagonals
        if (board[0][0].getText().toString().equals(board[1][1].getText().toString()) &&
                board[1][1].getText().toString().equals(board[2][2].getText().toString()) &&
                !board[0][0].getText().toString().isEmpty())


        {
            if (board[0][0].getText().toString().equals("X")) {
                toastplayero_two();
            } else {
                toastplayero_one();
            }
            return;
        }





        if (board[0][2].getText().toString().equals(board[1][1].getText().toString()) &&
                board[1][1].getText().toString().equals(board[2][0].getText().toString()) &&
                !board[0][2].getText().toString().isEmpty())


        {
            if (board[0][2].getText().toString().equals("X")) {
                toastplayero_two();
            } else {
                toastplayero_one();
            }
            return;
        }


    }





    public void toastplayero_one() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.ctoast, (ViewGroup) findViewById(R.id.layout1));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void toastplayero_two() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.ctoast2, (ViewGroup) findViewById(R.id.layout2));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
