package com.example.pr16nor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;

import io.paperdb.Paper;

public class Delete extends AppCompatActivity {
    private EditText ID;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_activity);

        ID = findViewById(R.id.Id);

        button = findViewById(R.id.DeleteDelete);

        button.setOnClickListener(v -> DeleteDel());
    }
    public void DeleteDel() {
        String idToDelete = ID.getText().toString(); // Получаем ID от пользователя

        ArrayList<UserBook> userList = Paper.book().read("UserData", new ArrayList<>());

        boolean found = false;
        Iterator<UserBook> iterator = userList.iterator(); // Создаем итератор
        while (iterator.hasNext()) {
            UserBook user = iterator.next();
            if (user.getId().equals(idToDelete)) { // Проверяем, есть ли пользователь с таким ID
                iterator.remove(); // Удаляем пользователя из списка
                found = true;
                break;
            }
        }

        if (found) {
            Paper.book().write("UserData", userList); // Сохраняем обновленный список
            Toast.makeText(this, "Пользователь успешно удален", Toast.LENGTH_SHORT).show();
            finish(); // Завершаем текущую активность
        } else {
            Toast.makeText(this, "Пользователь с таким ID не найден", Toast.LENGTH_SHORT).show();
        }
    }
}



