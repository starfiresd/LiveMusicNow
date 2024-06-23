package com.example.livemusicnowapp;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EventActivity extends AppCompatActivity {
    private Event currentEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_event);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle extras = getIntent().getExtras();
        /*if we have an extra we call the initEvent method and pass the id associated
         * with the key eventKey*/
        if(extras != null) {
            initEvent(extras.getInt("eventKey"));
            /*Think about is as open the extras and get the id mapped to the key eventKey
             * and pass that id to initEvent function*/
        } else {
            currentEvent = new Event();
        }
        setForEditing(false);
        /*currentEvent = new Event();*/

        initTextChangedEvents();
        initToggleButton();
        initHomeButton();
        initEventButton();
        initMapButton();
        initSettingsButton();
    }

    private void initToggleButton()
    {
        ToggleButton toggleButton = findViewById(R.id.switchActive);
        toggleButton.setOnClickListener(v -> setForEditing(toggleButton.isChecked()));
    }

    private void setForEditing(boolean enabled) {
        EditText editBand = findViewById(R.id.editTextBandLink);
        editBand.setEnabled(enabled);
        EditText editBandLink = findViewById(R.id.editTextBandLink);
        editBandLink.setEnabled(enabled);
        EditText editGenre= findViewById(R.id.editTextGenre);
        editGenre.setEnabled(enabled);
        EditText editDescription = findViewById(R.id.editTextDesc);
        editDescription.setEnabled(enabled);
        EditText editDate = findViewById(R.id.editTextDate);
        editDate.setEnabled(enabled);
        EditText editTime = findViewById(R.id.editTextTime);
        editTime.setEnabled(enabled);
        EditText editVenue = findViewById(R.id.editTextVenue);
        editVenue.setEnabled(enabled);
        EditText editAddress = findViewById(R.id.editTextVenueAddress);
        editAddress.setEnabled(enabled);
        EditText editCity = findViewById(R.id.editTextVenueCity);
        editCity.setEnabled(enabled);
        EditText editState = findViewById(R.id.editTextVenueState);
        editState.setEnabled(enabled);
        EditText editZipCode = findViewById(R.id.editTextVenueZip);
        editZipCode.setEnabled(enabled);
        EditText editVenueLink = findViewById(R.id.editTextVenueLink);
        editVenueLink.setEnabled(enabled);
        EditText editTicketPrice = findViewById(R.id.editTextTickets);
        editTicketPrice.setEnabled(enabled);
        EditText editTicketLink = findViewById(R.id.editTextTicketsLink);
        editTicketLink.setEnabled(enabled);
        EditText editLogoLink = findViewById(R.id.editTextLogoLink);
        editLogoLink.setEnabled(enabled);

        if (enabled) {
            editBand.requestFocus();
        } else {
            // *********************** NEED TO FIND ALTERNATIVE FOR THIS ****************************
            //ScrollView s = findViewById(R.id.controlsScrollView);
            //s.fullScroll(ScrollView.FOCUS_UP);
        }
    }
    public void initTextChangedEvents() {
        /*A reference to the first name EditText is assigned to the variable etTitle
         * This is declared as a final because it is used inside the event code*/
        final EditText etTitle = findViewById(R.id.editTextBandName);
        etTitle.addTextChangedListener(new TextWatcher() {
            @Override
            /*The beforeTextChanged is executed when a user presses down on a key to enter
             * the EditText but before the value in the EditText is actually changed*/
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            /*The onTextChanged method is executed after each and every character change in
             * the EditText*/
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setBandName(etTitle.getText().toString());
            }
        });

        final EditText etBandLink = findViewById(R.id.editTextBandLink);
        etBandLink.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setBandLink(etBandLink.getText().toString());
            }
        });

        final EditText etGenre = findViewById(R.id.editTextGenre);
        etGenre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setGenre(etGenre.getText().toString());
            }
        });

        final EditText etDescription = findViewById(R.id.editTextDesc);
        etDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setDescription(etDescription.getText().toString());
            }
        });

        final EditText etDate = findViewById(R.id.editTextDate);
        etDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setDescription(etDate.getText().toString());
            }
        });

        final EditText etTime = findViewById(R.id.editTextTime);
        etTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setTime(etTime.getText().toString());
            }
        });

        final EditText etVenue = findViewById(R.id.editTextVenue);
        etVenue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setVenue(etVenue.getText().toString());
            }
        });

        final EditText etAddress = findViewById(R.id.editTextVenueAddress);
        etAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setAddress(etAddress.getText().toString());
            }
        });
        final EditText etCity = findViewById(R.id.editTextVenueCity);
        etCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setCity(etCity.getText().toString());
            }
        });

        final EditText etState = findViewById(R.id.editTextVenueState);
        etState.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setState(etState.getText().toString());
            }
        });

        final EditText etZipCode = findViewById(R.id.editTextVenueZip);
        etZipCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setZipCode(etZipCode.getText().toString());
            }
        });

        final EditText etVenueLink = findViewById(R.id.editTextVenueLink);
        etVenueLink.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setVenueLink(etVenueLink.getText().toString());
            }
        });

        final EditText etTicketPrice = findViewById(R.id.editTextTickets);
        etTicketPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setTicketPrice(etTicketPrice.getText().toString());
            }
        });

        final EditText etTicketLink = findViewById(R.id.editTextTicketsLink);
        etTicketLink.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setTicketLink(etTicketLink.getText().toString());
            }
        });

        final EditText etLogoLink = findViewById(R.id.editTextLogoLink);
        etLogoLink.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentEvent.setLogoLink(etLogoLink.getText().toString());
            }
        });
    }
    public void initSaveButton(){
        // declare the widget to use the listener
        Button saveButton = findViewById(R.id.saveButton);
        // assign a listener for the widget
        saveButton.setOnClickListener(v -> {
            hideKeyboard();
            /*The value of the boolean is false unless explicitly declared as true
             * The variable captures the return of the datasource methods and is used to determine
             * the operations that should be performed upon a successful action*/
            boolean wasSuccessful;
            EventsDataSource ds = new EventsDataSource(EventActivity.this);
            try {
                ds.open();
                /*The current textbook id is compared to -1. If -1 this is a new record,
                 * otherwise it is an existing record. If new you implement insert method,
                 * else update methods*/
                if (currentEvent.getEventID() == - 1) {
                    wasSuccessful = ds.insertEvent(currentEvent);
                    if (wasSuccessful) {
                        int newId = ds.getLastEventID();
                        currentEvent.setEventID(newId);
                    }
                } else {
                    wasSuccessful = ds.updateEvent(currentEvent);
                }
                ds.close();
            } catch (Exception e) {
                wasSuccessful = false;
            }
            if (wasSuccessful) {
                ToggleButton toggleButton = findViewById(R.id.switchActive);
                toggleButton.toggle();
                setForEditing(false);
            }
        });
    }
    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        EditText editBand = findViewById(R.id.editTextBandName);
        imm.hideSoftInputFromWindow(editBand.getWindowToken(), 0);
        EditText editBandLink = findViewById(R.id.editTextBandLink);
        imm.hideSoftInputFromWindow(editBandLink.getWindowToken(), 0);
        EditText editGenre= findViewById(R.id.editTextGenre);
        imm.hideSoftInputFromWindow(editGenre.getWindowToken(), 0);
        EditText editDescription = findViewById(R.id.editTextDesc);
        imm.hideSoftInputFromWindow(editDescription.getWindowToken(), 0);
        EditText editDate = findViewById(R.id.editTextDate);
        imm.hideSoftInputFromWindow(editDate.getWindowToken(), 0);
        EditText editTime = findViewById(R.id.editTextTime);
        imm.hideSoftInputFromWindow(editTime.getWindowToken(), 0);
        EditText editVenue = findViewById(R.id.editTextVenue);
        imm.hideSoftInputFromWindow(editVenue.getWindowToken(), 0);
        EditText editAddress = findViewById(R.id.editTextVenueAddress);
        imm.hideSoftInputFromWindow(editAddress.getWindowToken(), 0);
        EditText editCity = findViewById(R.id.editTextVenueCity);
        imm.hideSoftInputFromWindow(editCity.getWindowToken(), 0);
        EditText editState = findViewById(R.id.editTextVenueState);
        imm.hideSoftInputFromWindow(editState.getWindowToken(), 0);
        EditText editZipCode = findViewById(R.id.editTextVenueZip);
        imm.hideSoftInputFromWindow(editZipCode.getWindowToken(), 0);
        EditText editVenueLink = findViewById(R.id.editTextVenueLink);
        imm.hideSoftInputFromWindow(editVenueLink.getWindowToken(), 0);
        EditText editTicketPrice = findViewById(R.id.editTextTickets);
        imm.hideSoftInputFromWindow(editTicketPrice.getWindowToken(), 0);
        EditText editTicketLink = findViewById(R.id.editTextTicketsLink);
        imm.hideSoftInputFromWindow(editTicketLink.getWindowToken(), 0);
        EditText editLogoLink = findViewById(R.id.editTextLogoLink);
        imm.hideSoftInputFromWindow(editLogoLink.getWindowToken(), 0);
    }
    private void initEvent(int id) { /*The id here is the textbookId*/
        EventsDataSource eventsDataSource  = new EventsDataSource(EventActivity.this);
        try {
            eventsDataSource.open();
            /*Get textbook data and enter it into currentEvent*/
            currentEvent = eventsDataSource.getSpecificEvent(id);
            eventsDataSource.close();
        } catch (SQLException e) {
            Toast.makeText(this, "Load Event failed", Toast.LENGTH_LONG).show();
        }
        /*Create a reference to the widgets*/
        EditText editBand = findViewById(R.id.editTextBandName);
        EditText editBandLink = findViewById(R.id.editTextBandLink);
        EditText editGenre= findViewById(R.id.editTextGenre);
        EditText editDescription = findViewById(R.id.editTextDesc);
        EditText editDate = findViewById(R.id.editTextDate);
        EditText editTime = findViewById(R.id.editTextTime);
        EditText editVenue = findViewById(R.id.editTextVenue);
        EditText editAddress = findViewById(R.id.editTextVenueAddress);
        EditText editCity = findViewById(R.id.editTextVenueCity);
        EditText editState = findViewById(R.id.editTextVenueState);
        EditText editZipCode = findViewById(R.id.editTextVenueZip);
        EditText editVenueLink = findViewById(R.id.editTextVenueLink);
        EditText editTicketPrice = findViewById(R.id.editTextTickets);
        EditText editTicketLink = findViewById(R.id.editTextTicketsLink);
        EditText editLogoLink = findViewById(R.id.editTextLogoLink);


        /*Widgets are set to display the values of the selected textbook*/
        editBand.setText(currentEvent.getBandName());
        editBandLink.setText(currentEvent.getBandLink());
        editGenre.setText(currentEvent.getGenre());
        editDescription.setText(currentEvent.getDescription());
        editDate.setText(currentEvent.getDate());
        editTime.setText(currentEvent.getTime());
        editVenue.setText(currentEvent.getVenue());
        editAddress.setText(currentEvent.getAddress());
        editCity.setText(currentEvent.getCity());
        editState.setText(currentEvent.getState());
        editZipCode.setText(currentEvent.getZipCode());
        editVenueLink.setText(currentEvent.getVenueLink());
        editTicketPrice.setText(currentEvent.getTicketPrice());
        editTicketLink.setText(currentEvent.getTicketLink());
        editLogoLink.setText(currentEvent.getLogoLink());
    }

    private void initHomeButton(){
        Button button = findViewById(R.id.btn_main_home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    private void initEventButton(){
        Button button = findViewById(R.id.btn_main_event);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, EventActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    private void initMapButton(){
        Button button = findViewById(R.id.btn_main_map);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, MapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    private void initSettingsButton(){
        Button button = findViewById(R.id.btn_main_settings);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, SettingsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}