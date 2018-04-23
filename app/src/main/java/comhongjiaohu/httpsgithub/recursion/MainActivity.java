/**
 * Name:Hongjiao Hu
 * Course:CS40S
 * Teacher:Mr.Hardman
 * Lab #4,Program# 1
 * Date Last Modified: 4/23/18
 */
package comhongjiaohu.httpsgithub.recursion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private EditText mUserInput;
    private TextView mRuselt;
    private TextView mErrorNessage;

    @Override
    /**
     * onCreate is the method that is executed when the Activity is created
     *
     * @param savedInstanceState is a Bundle of data use to restore
     *                           the Activity from a previous instance
     * @return "" Nothing is returned
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserInput = (EditText) findViewById(R.id.et_user_input);
        mRuselt = (TextView) findViewById(R.id.tv_result);
        mErrorNessage = (TextView) findViewById(R.id.tv_error_message);

        mUserInput.addTextChangedListener( numberInputWatcher );
    }

    private final TextWatcher numberInputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        /**
         * afterTextChanged is the method taht is executed when the user enters text into the Editable object
         *
         * @param editable is the object that the user types input into
         * @return "" Nothing is returned
         */
        public void afterTextChanged(Editable editable) {

            String userInput;
            boolean reusltPalindromeCheck;

            if (editable.length() == 0 )
            {
                mRuselt.setText("");
                mErrorNessage.setText("You must enter a word!");
            }
            else
            {
                mRuselt.setText("");
                mErrorNessage.setText("");

                userInput = mUserInput.getText().toString().toUpperCase();

                reusltPalindromeCheck = checkPalindrome( userInput, 0 );

                if ( reusltPalindromeCheck == true )
                {
                    mRuselt.setText("That is a paindrome.");

                }
                else
                {
                    mRuselt.setText("That is not a paindrome.");
                }
            }

        }
    };

    //This is where the TextWatcher has closed

    /**
     * checkPalindrome check the word this is or not a palindrome
     *
     * @param userWord an String that stores what the user's input
     * @param currentIndex is the current number of the checkPalindrome
     *
     * @return an boolean that stores the checkPalindrome result
     */
    private boolean checkPalindrome( String userWord, int currentIndex )
    {
        boolean result;

        int indexFromEnd = userWord.length() - currentIndex - 1;

        if ( userWord.charAt(currentIndex) == userWord.charAt(indexFromEnd) )
        {
            if (currentIndex == indexFromEnd || currentIndex == indexFromEnd - 1)
            {
                result = true;
            }
            else
            {
                result = checkPalindrome( userWord, currentIndex + 1);
            }
        }
        else
        {
            result = false;
        }

        return result;
    }
}
