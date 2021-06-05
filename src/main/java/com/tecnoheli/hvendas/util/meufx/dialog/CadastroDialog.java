package com.tecnoheli.hvendas.util.meufx.dialog;

import com.tecnoheli.hvendas.views.CadastroFornecedorView;
import com.tecnoheli.hvendas.views.CadastroFuncionarioView;
import com.tecnoheli.hvendas.views.CadastroProdutoView;
import javafx.stage.Stage;

public class CadastroDialog {

    public static void funcionario() throws Exception {
        if (liberado())
            new CadastroFuncionarioView().start(new Stage());
    }

    public static void fornecedor() throws Exception {
        if (liberado())
            new CadastroFornecedorView().start(new Stage());
    }

    public static void produto() throws Exception {
        if (liberado())
            new CadastroProdutoView().start(new Stage());
    }

    private static boolean liberado() {
        return !(CadastroFornecedorView.isAberto() ||
                CadastroFuncionarioView.isAberto() ||
                CadastroProdutoView.isAberto());
    }
}
