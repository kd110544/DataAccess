package tw.org.dataaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class ActFile extends AppCompatActivity {
    private View.OnClickListener btnSave_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                OutputStream streamOut = openFileOutput(
                        "MyFile.txt",Activity.MODE_PRIVATE);

                streamOut.write(lblInputText.getText().toString().getBytes("utf-8"));
                streamOut.close();
                Toast.makeText(ActFile.this, "寫入資料成功!", Toast.LENGTH_SHORT).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    };
    private View.OnClickListener btnGet_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                InputStream streamIn =openFileInput("MyFile.txt");
                byte[] datas = new byte[1000];
                int count = streamIn.read(datas);
                String content = new String(datas,0,count,"utf-8");
                lblShowMessage.setText(content);

                Toast.makeText(ActFile.this, "讀取資料成功!", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    };
    private View.OnClickListener btnClear_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            SharedPreferences table = getSharedPreferences("T1", Activity.MODE_PRIVATE);
//            SharedPreferences.Editor row = table.edit();
//            row.putString("KK",null).commit();
//            lblInputText.setText(" ");
//            lblShowMessage.setText(" ");
//
//            Toast.makeText(ActShared.this, "清除資料成功!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common);
        InitialComponent();
    }

    private void InitialComponent() {
        lblInputText = findViewById(R.id.lblInputText);
        lblShowMessage = findViewById(R.id.lblShowMessage);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(btnSave_Click);
        btnGet = findViewById(R.id.btnGet);
        btnGet.setOnClickListener(btnGet_Click);
        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(btnClear_Click);

    }

    EditText lblInputText;
    TextView lblShowMessage;
    Button btnSave;
    Button btnGet;
    Button btnClear;
}
