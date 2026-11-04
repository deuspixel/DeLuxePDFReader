
package com.deluxe.pdfreader;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity {

    private static final int PICK_PDF = 100;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);

        LinearLayout home = new LinearLayout(this);
        home.setOrientation(LinearLayout.VERTICAL);
        home.setPadding(28, 40, 28, 24);
        home.setBackgroundColor(Color.rgb(9, 20, 21));

        TextView title = new TextView(this);
        title.setText("DeLuxe PDF Reader");
        title.setTextSize(27);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER_VERTICAL);
        home.addView(title);

        TextView library = new TextView(this);
        library.setText("My Library");
        library.setTextSize(22);
        library.setTextColor(Color.WHITE);
        library.setPadding(0, 60, 0, 30);
        home.addView(library);

        Button open = new Button(this);
        open.setText("Add PDF");
        open.setOnClickListener(v -> {
            Intent intent = new Intent(
                Intent.ACTION_OPEN_DOCUMENT);
            intent.setType("application/pdf");
            intent.addCategory(
                Intent.CATEGORY_OPENABLE);
            startActivityForResult(intent, PICK_PDF);
        });
        home.addView(open);

        setContentView(home);
    }

    @Override
    protected void onActivityResult(
        int requestCode, int resultCode, Intent data) {
        super.onActivityResult(
            requestCode, resultCode, data);

        if (requestCode == PICK_PDF
            && resultCode == RESULT_OK
            && data != null) {
            Uri pdf = data.getData();
            if (pdf != null) {
                Intent view = new Intent(
                    Intent.ACTION_VIEW);
                view.setDataAndType(
                    pdf, "application/pdf");
                view.addFlags(
                    Intent.FLAG_GRANT_READ_URI_PERMISSION);
                try {
                    startActivity(view);
                } catch (android.content.ActivityNotFoundException e) {
                    android.widget.Toast.makeText(
                        this,
                        "No PDF viewer installed",
                        android.widget.Toast.LENGTH_LONG
                    ).show();
                }
            }
        }
    }
}
