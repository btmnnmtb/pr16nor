package com.example.pr16nor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditEdit  extends AppCompatActivity {
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

        // Получаем режим и данные пользователя
        String mode = getIntent().getStringExtra("mode");
        UserBook userBook = (UserBook) getIntent().getSerializableExtra("userBook");

        // Инициализация полей
        id_id = findViewById(R.id.id);
        name_author = findViewById(R.id.nameauthor);
        name_book = findViewById(R.id.namebook);
        email_author = findViewById(R.id.email_author);
        nuber_phone = findViewById(R.id.nuber_phone);
        button = findViewById(R.id.dobavit);

        // Заполнение полей данными пользователя в режиме редактирования
        if ("edit".equals(mode) && userBook != null) {
            id_id.setText(userBook.getId());
            name_author.setText(userBook.getNameAuthor());
            name_book.setText(userBook.getNameBook());
            email_author.setText(userBook.getEmailAuthor());
            nuber_phone.setText(userBook.getNumberPhone());
        }

        button.setOnClickListener(v -> saveData(mode, userBook)); // Передаем режим и userBook в saveData
    }

    private void saveData(String mode, UserBook userBook) {
        String id = id_id.getText().toString();
        String author = name_author.getText().toString();
        String book = name_book.getText().toString();
        String email = email_author.getText().toString();
        String phone = nuber_phone.getText().toString();

        if ("edit".equals(mode) && userBook != null) {
            // Обновление данных
            userBook.setNameAuthor(author);
            userBook.setNameBook(book);
            userBook.setEmailAuthor(email);
            userBook.setNumberPhone(phone);

            // Отправка обновленного объекта обратно в MainActivity
            Intent intent = new Intent();
            intent.putExtra("userBook", userBook);
            setResult(RESULT_OK, intent);
        } else {
            // Создание нового объекта UserBook
            UserBook newUserBook = new UserBook(id, author, book, email, phone);
            Intent intent = new Intent();
            intent.putExtra("userBook", newUserBook);
            setResult(RESULT_OK, intent);
        }
        finish();
    }
}
