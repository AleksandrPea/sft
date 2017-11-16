package com.kpi.sft;

import com.kpi.sft.core.DuplicateLinesRemover;

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        // Here is example
        try {
            DuplicateLinesRemover remover = DuplicateLinesRemover.createRemoverWithBaseFile("D:\\Downloads\\base.txt");
            remover.writeLinesTo("D:\\Downloads\\result.txt",
                                 remover.refine("D:\\Downloads\\someFile.txt"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
