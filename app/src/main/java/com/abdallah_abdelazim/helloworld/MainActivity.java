package com.abdallah_abdelazim.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * This is the main activity in this application.
 * Applications can have as many activities as you want.
 * The activity represents a single screen with a user interface that users interacts with.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is starting.
     * Here is where you initialize your activity.
     * @param savedInstanceState A Bundle object.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Click handler method for the "CLICK ME" button.
     * called whenever the user clicks that button.
     * @param view The view that the user clicked on, i.e. the "CLICK ME" button.
     */
    public void onClickMeButtonClicked(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(getString(R.string.hello_world));
    }

    /**
     * Specifies the options menu for this activity.
     * This method works by populating the activity's options menu, which is empty by default,
     * with the menu layout you specify, you can find the menu layout specified here at res/menu/menu_main.xml.
     * @param menu The activity's options menu.
     * @return A boolean indicating whether to show the options menu or not. The default implementation returns false (no options menu), so you have to return true in order that the options menu is displayed.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * This method is called whenever a menu item is selected from the activity's options menu.
     * You can identify which item the user selected by matching the selected item against the known menu items.
     * @param item The menu item the user has selected.
     * @return A boolean indicating that the menu item selection has been dealt with. The default implementation of this method return false, so you must return true indicating that you have handled the menu item selection.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_get_source_code) {
            openWebPage(getString(R.string.url_source_code));
            return true;
        }
        else if (id == R.id.action_training) {
            openWebPage(getString(R.string.url_training));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A utility function to open an installed web browser application with the given URL.
     * You don't have to worry for the internal implementation for now.
     * @param url The website URL you want to open.
     */
    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
