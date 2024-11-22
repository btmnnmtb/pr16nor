package com.example.pr16nor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<UserBook> userList;
    private String storageKey = "UserData";
    private TextView stroka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paper.init(this);

        stroka = findViewById(R.id.stroka);
        userList = new ArrayList<>();

        Button buttonn = findViewById(R.id.edit_text_id);
        buttonn.setOnClickListener(v -> startActivityForResult(new Intent(MainActivity.this, AddData.class), 1));

        Button buttonnn = findViewById(R.id.delt_id);
        buttonnn.setOnClickListener(v -> startActivityForResult(new Intent(MainActivity.this, Delete.class), 1));
        Button buttonnnn = findViewById(R.id.update);
        buttonnnn.setOnClickListener(v -> startActivityForResult(new Intent(MainActivity.this, EditEdit.class), 1));

        loadData(); // Загружаем данные при создании активности
        displayData(); // Отображаем их
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData(); // Загружаем данные при возвращении в активность
        displayData(); // Обновляем отображение данных
    }

    private void loadData() {
        userList = Paper.book().read(storageKey, new ArrayList<>()); // Чтение списка пользователей
    }

    private void displayData() {
        if (userList.isEmpty()) {
            stroka.setText("Нет данных для отображения");
        } else {
            StringBuilder data = new StringBuilder();
            for (UserBook user : userList) {
                data.append("ID: ").append(user.getId()).append("\n")
                        .append("User Name: ").append(user.getNameAuthor()).append("\n")
                        .append("User book: ").append(user.getNameBook()).append("\n")
                        .append("User email: ").append(user.getEmailAuthor()).append("\n")
                        .append("User number: ").append(user.getNumberPhone()).append("\n\n");
            }
            stroka.setText(data.toString());
        }
    }


    private void saveData() {
        Paper.book().write(storageKey, userList);
        Toast.makeText(this, "Data Saved успешно", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            UserBook userBook = (UserBook) data.getSerializableExtra("userBook");
            if (userBook != null) {
                // Проверяем, существует ли пользователь в списке
                boolean userExists = false;
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).getId().equals(userBook.getId())) {
                        userList.set(i, userBook); // Обновляем существующего пользователя
                        userExists = true;
                        break;
                    }
                }

                if (!userExists) {
                    userList.add(userBook); // Добавляем нового пользователя
                }

                saveData(); // Сохраняем изменения
                displayData(); // Обновляем отображение данных
            }
        }
    }
}