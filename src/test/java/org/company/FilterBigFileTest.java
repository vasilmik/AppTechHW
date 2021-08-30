package org.company;

import org.junit.Assert;
import org.junit.Test;
import java.util.BitSet;
import java.util.Scanner;

public class FilterBigFileTest {

    @Test
    public void commonTest() {

        Scanner scanner = new Scanner(
                "aaaaaaaaaaaaaaaaaaaa aaaaaaaaaa aaaaaaaaaa aaa" + System.lineSeparator()+
                "bbbbbbbb bbbbb bbbbbbbbbbbbbbbbbbbbbbb" + System.lineSeparator()+
                "vvvvvvvvvv vvvvvvvvvvv" + System.lineSeparator()+
                "aaaaaaaaaaaaaaaaaaaa aaaaaaaaaa aaaaaaaaaa aaa" + System.lineSeparator()+
                "mmmmmmmmmmmmmmmmmmmmmmmmmm" + System.lineSeparator()+
                "jjj jjj jjj" + System.lineSeparator()+
                "jjj jjj jjj" + System.lineSeparator()+
                "aaaaaaaaaaaaaaaaaaaa aaaaaaaaaa aaaaaaaaaa aaa" + System.lineSeparator()+
                "bbbbbbbb bbbbb bbbbbbbbbbbbbbbbbbbbbbb"+System.lineSeparator()+
                "jjj jjj jjj" + System.lineSeparator());

        BitSet bitSet = new BitSet();
        bitSet.set(2);
        bitSet.set(4);

        Assert.assertEquals(FilterBigFile.filterText(scanner),bitSet);

    }

    @Test
    public void fullTest() {

        Scanner scanner = new Scanner(
                "aaaaaaaaaaaaaaaaaaaa aaaaaaaaaa aaaaaaaaaa aaa" + System.lineSeparator()+
                        "bbbbbbbb bbbbb bbbbbbbbbbbbbbbbbbbbbbb" + System.lineSeparator()+
                        "vvvvvvvvvv vvvvvvvvvvv" + System.lineSeparator()+
                        "jjj jjj jjj");

        BitSet bitSet = new BitSet();
        bitSet.set(0);
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(3);

        Assert.assertEquals(FilterBigFile.filterText(scanner),bitSet);

    }

    @Test
    public void emptyTest() {

        Scanner scanner = new Scanner("");
        BitSet bitSet = new BitSet();

        Assert.assertEquals(FilterBigFile.filterText(scanner),bitSet);

    }

    @Test
    public void doubleTest() {

        Scanner scanner = new Scanner(
                        "jjj jjj jjj" + System.lineSeparator()+
                        "jjj jjj jjj" + System.lineSeparator());

        BitSet bitSet = new BitSet();

        Assert.assertEquals(FilterBigFile.filterText(scanner),bitSet);

    }


}