package fr.renater.idegest.tu;

import java.io.IOException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class GestAjoutUsersTest extends TestCase {
	  /** l'OUT */
	  private GestAjoutUsers gau;                           // 1
	 
	  @Before
	  protected void setUp() throws Exception {
	    try {
	      this.gau = new GestAjoutUsers("testusers.xml");   // 2
	    } catch (IOException e) {
	      fail("Création de l'OUT impossible !");
	    }
	  }
	 
	  @Test
	  public void test2PremiersCarsGenUid() {
	    String uid = this.gau.genUid("Bob", "Martin");                      // 3 
	    assertTrue("Les 2 premiers caractères sont valides", uid.startsWith("bm"));  // 4
	  }
	  
	  @Test
	  public void test2PremiersCarsGenUidBis() {
	    String uid = this.gau.genUid("Bob", "Martin");                 // 1
	    String premscar = uid.substring(0, 2);                         // 2
	    assertEquals("Les 2 premiers caractères sont valides", "bm", premscar); // 3
	  }
	  
	  @Test
	  public void testMinusculeUid() {
		    String uid = this.gau.genUid("Bob", "Martin");                      // 3 
		    assertEquals("Les caractères sont en minuscule", uid.toLowerCase(), uid);  // 4
		  }
	
	  @Test
	  public void testLongueurUid() {
		    String uid = this.gau.genUid("Bob", "Martin");                      // 3 
		    assertTrue("Les caractères sont composés au minimum de 5 caractères et maximum de 9 ", uid.length() >= 5 && uid.length() <= 9);  // 4
		  }
	
	}