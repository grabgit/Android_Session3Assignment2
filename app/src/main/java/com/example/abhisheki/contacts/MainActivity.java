package com.example.abhisheki.contacts;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    static final int PICK_CONTACT_REQUEST = 1;
    Button btncontacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncontacts = (Button) findViewById(R.id.btnContacts);
        btncontacts.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        pickContact();
    }

    private void pickContact() {
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_CONTACT_REQUEST)
        {
           if (resultCode == RESULT_OK)
           {
               Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
           }
        }
    }
}

