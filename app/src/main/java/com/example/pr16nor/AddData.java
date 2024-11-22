package com.example.pr16nor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddData extends AppCompatActivity {
    private EditText name_author;
    private EditText name_book;
    private EditText email_author;
    private EditText nuber_phone;
    private EditText id_id;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittextactivity);
        id_id = findViewById(R.id.id);

        name_author = findViewById(R.id.nameauthor);
        name_book = findViewById(R.id.namebook);
        email_author = findViewById(R.id.email_author);
        nuber_phone = findViewById(R.id.nuber_phone);
        button = findViewById(R.id.dobavit);

        button.setOnClickListener(v -> saveData());

    }

    private void saveData() {
        String id = id_id.getText().toString() ;
        String author = name_author.getText().toString();
        String book = name_book.getText().toString();
        String email = email_author.getText().toString();
        String phone = nuber_phone.getText().toString();

        // Создание нового объекта UserBook
        UserBook userBook = new UserBook(id ,author, book, email, phone);

        // Отправка данных обратно в MainActivity
        Intent intent = new Intent();
        intent.putExtra("userBook", userBook); // Передача объекта
        setResult(RESULT_OK, intent);

         // Завершение текущей активности
        finish();
    }
}