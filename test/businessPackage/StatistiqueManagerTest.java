package businessPackage;

import org.junit.*;

public class StatistiqueManagerTest {

    private StatistiqueManager stats;

    @Before
    public void setUp() throws Exception {
        stats = new StatistiqueManager();
    }

    @Test
    public void getPrixMoyen() throws Exception{
        Assert.assertEquals(50.0,stats.getPrixMoyen(100.0,2),0.001);
        Assert.assertEquals(33.333,stats.getPrixMoyen(100.0,3),0.001);
        Assert.assertEquals(0, stats.getPrixMoyen(0.0,100),0.001);
    }

    @Test
    public void getPartDeMarche() throws Exception {
        Assert.assertEquals(10,stats.getPartDeMarche(100,1000), 0.001);
        Assert.assertEquals(16.667,stats.getPartDeMarche(100,600), 0.001);
        Assert.assertEquals(0,stats.getPartDeMarche(0,600), 0.001);
    }

    @Test
    public void getTVA() throws Exception {
        Assert.assertEquals(0.21, stats.getTVA(1.0),0.001);
    }
}