package com.jaynewstrom.screenswitchersample.second;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.jaynewstrom.screenswitchersample.R;
import com.jnewstrom.screenswitcher.dialoghub.DialogFactory;

import javax.inject.Inject;

final class SecondScreenDialogFactory implements DialogFactory {
    private Bundle bundle;

    @Inject
    SecondScreenDialogFactory() {
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Dialog createDialog(Context context) {
        Dialog dialog = new AlertDialog.Builder(context).setView(R.layout.dialog_content).setTitle("Second Dialog").setMessage("Rotate to test!").create();
        if (bundle != null) {
            dialog.onRestoreInstanceState(bundle);
        }
        return dialog;
    }

    @Override
    public void saveState(Dialog dialog) {
        bundle = dialog.onSaveInstanceState();
    }
}
