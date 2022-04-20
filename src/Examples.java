import static org.junit.Assert.*;
import org.junit.Test;

public class Examples extends HeapChecker{

    HeapChecker hc = new HeapChecker();

    IHeap smallHeap = new DataHeap(5, new DataHeap(6, new MtHeap(), new MtHeap()), new MtHeap());

    IHeap medHeap = new DataHeap(8,
            new DataHeap(21, new MtHeap(), new MtHeap()),
            new DataHeap(11, new MtHeap(),
                    new DataHeap(12, new MtHeap(), new MtHeap())));

    public Examples() {

    }

    @Test
    public void addElt_testBasicFunctionality1() {
        assertTrue(addEltTester(smallHeap, 8, smallHeap.addElt(8)));
    }

    @Test
    public void addElt_testBasicFunctionality2() {
        assertTrue(addEltTester(smallHeap, 3, smallHeap.addElt(3)));
    }

    @Test
    public void addElt_testBasicFunctionality3() {
        assertFalse(addEltTester(smallHeap, 8, smallHeap.addElt(3)));
    }

    @Test
    public void addElt_testBasicFunctionality4() {
        assertFalse(addEltTester(smallHeap, 3, smallHeap.addElt(8)));
    }

    @Test
    public void addElt_testMoreFunctionality1() {
        assertTrue(addEltTester(medHeap, 4, medHeap.addElt(4)));
    }

    @Test
    public void addElt_testMoreFunctionality2(){
        assertTrue(addEltTester(medHeap, 9, medHeap.addElt(9)));
    }

    @Test
    public void addElt_testMoreFunctionality3() {
        assertTrue(addEltTester(medHeap, 15, medHeap.addElt(15)));
    }

    @Test
    public void addElt_testMoreFunctionality4() {
        assertFalse(addEltTester(medHeap, 14, medHeap.addElt(15)));
    }

    @Test
    public void addElt_testSimilarHeap1() {
        //Tests a heap with one random item of a different value
        IHeap similarHeap = new DataHeap(8,
                new DataHeap(21, new MtHeap(), new MtHeap()),
                new DataHeap(10, new MtHeap(),
                        new DataHeap(12, new MtHeap(),
                                new DataHeap(14, new MtHeap(), new MtHeap()))));

        assertFalse(addEltTester(medHeap, 14, similarHeap));
    }

    @Test
    public void addElt_testSimilarHeap2() {
        //Tests a heap with one random item of a different value
        IHeap similarHeap = new DataHeap(7,
                new DataHeap(21, new MtHeap(), new MtHeap()),
                new DataHeap(11, new MtHeap(),
                        new DataHeap(12, new MtHeap(),
                                new DataHeap(14, new MtHeap(), new MtHeap()))));

        assertFalse(addEltTester(medHeap, 14, similarHeap));
    }

    @Test
    public void addElt_testSimilarHeap3() {
        //Tests a heap with another element added
        IHeap similarHeap = new DataHeap(7,
                new DataHeap(21, new MtHeap(), new MtHeap()),
                new DataHeap(11,
                        new DataHeap(15, new MtHeap(), new MtHeap()),
                        new DataHeap(12, new MtHeap(),
                                new DataHeap(14, new MtHeap(), new MtHeap()))));

        assertFalse(addEltTester(medHeap, 14, similarHeap));
    }

    @Test
    public void addElt_testSimilarHeap4() {
        //Tests a heap with another element (with the same value as an element already there) added

        IHeap similarHeap = medHeap.addElt(14).addElt(14);
        assertFalse(addEltTester(medHeap, 14, similarHeap));
    }

    @Test
    public void addElt_testnoChange1() {
        assertFalse(addEltTester(smallHeap, 100, smallHeap));
    }

    @Test
    public void addElt_testnoChange2() {
        assertFalse(addEltTester(medHeap, 100, medHeap));
    }

    @Test
    public void remMinElt_testBasicFunctionality1() {
        assertTrue(remMinEltTester(smallHeap, smallHeap.remMinElt()));
    }

    @Test
    public void remMinElt_testBasicFunctionality2() {
        assertTrue(remMinEltTester(medHeap, medHeap.remMinElt()));
    }

    @Test
    public void remMinElt_noChange1() {
        assertFalse(remMinEltTester(smallHeap, smallHeap));
    }

    @Test
    public void remMinElt_noChange2() {
        assertFalse(remMinEltTester(medHeap, medHeap));
    }

    @Test
    public void remMinElt_similar1() {
        IHeap similarHeap = new DataHeap(5, new MtHeap(), new MtHeap());

        assertFalse(remMinEltTester(smallHeap, similarHeap));
    }

    @Test
    public void remMinElt_similar2() {
        IHeap similarHeap = new DataHeap(6, new DataHeap(6, new MtHeap(), new MtHeap()), new MtHeap());

        assertFalse(remMinEltTester(smallHeap, similarHeap));
    }

    @Test
    public void remMinElt_similar3() {
        //replace min elt with a different elt
        IHeap similarHeap = new DataHeap(4,
                new DataHeap(21, new MtHeap(), new MtHeap()),
                new DataHeap(11, new MtHeap(),
                        new DataHeap(12, new MtHeap(), new MtHeap())));

        assertFalse(remMinEltTester(medHeap, similarHeap));
    }

    @Test
    public void remMinElt_similar4() {
        //not a heap
        IHeap similarHeap = new DataHeap(21,
                new DataHeap(11, new MtHeap(), new MtHeap()),
                new DataHeap(12, new MtHeap(), new MtHeap()));

        assertFalse(remMinEltTester(medHeap, similarHeap));
    }

    @Test
    public void remMinElt_similar5() {
        //other not relevant element changed
        IHeap similarHeap = new DataHeap(11,
                new DataHeap(21, new MtHeap(), new MtHeap()),
                new DataHeap(13, new MtHeap(), new MtHeap()));

        assertFalse(remMinEltTester(medHeap, similarHeap));
    }





}
