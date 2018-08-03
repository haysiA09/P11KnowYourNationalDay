package sg.edu.rp.webservices.p11_knowyournationalday;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<String> al;
ArrayAdapter<String>ad;
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout passPhrase =
                (LinearLayout) inflater.inflate(R.layout.login, null);
        final EditText etPassphrase = (EditText) passPhrase
                .findViewById(R.id.editTextPassPhrase);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AccessCode")
                .setView(passPhrase)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this, "You had entered " +
                                etPassphrase.getText().toString(), Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        lv=(ListView)findViewById(R.id.lv);
        al=new ArrayList<>();
        al.add("Singapore National Day is on 9 Aug");
        al.add("Singapore is 53 years old");
        al.add("Theme is #OneNationTogether");
        ad=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(ad);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Tally against the respective action item clicked
        //  and implement the appropriate action
        if (item.getItemId() == R.id.itemsendFriend) {
            String [] list = new String[] { "SMS", "Email" };
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select the way to enrich your friend")
                    // Set the list of items easily by just supplying an
                    //  array of the items
                    .setItems(list, new DialogInterface.OnClickListener() {
                        // The parameter "which" is the item index
                        // clicked, starting from 0
                        public void onClick(DialogInterface dialog, int which) {
                            if (which == 0) {
                                //SmsManager smsManager=SmsManager.getDefault();
                                //smsManager.sendTextMessage();
                            } else if (which == 1) {
                                Snackbar.make(lv, "Email Selected!!", Snackbar.LENGTH_SHORT).show();

                            }
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();


        } else if (item.getItemId() == R.id.itemQuiz) {

        } else if (item.getItemId() == R.id.itemQuit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Quit?")
                    // Set text for the positive button and the corresponding
                    //  OnClickListener when it is clicked
                    .setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    // Set text for the negative button and the corresponding
                    //  OnClickListener when it is clicked
                    .setNegativeButton("Not Really",null);
            // Create the AlertDialog object and return it
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
        return super.onOptionsItemSelected(item);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }





}
