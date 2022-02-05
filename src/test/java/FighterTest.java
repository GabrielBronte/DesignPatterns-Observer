import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FighterTest {
    @Test
    void deveNotificarOrganizacao() {
        Arena arena = new Arena("Maracanãzinho", "Rio de Janeiro", "RJ", 11800);
        Organization org = new Organization("UFC");
        org.addObserver(arena);
        arena.getArena();
        assertEquals("UFC, nova arena disponivel para contato: Arena{name='Maracanãzinho', city='Rio de Janeiro', state='RJ', capacity=11800}", org.getLastUpdate());
    }

    @Test
    void deveNotificarOrganizacoes() {
        Arena arena = new Arena("Maracanãzinho", "Rio de Janeiro", "RJ", 11800);
        Organization ufc = new Organization("UFC");
        Organization bellator = new Organization("Bellator");
        ufc.addObserver(arena);
        bellator.addObserver(arena);
        arena.getArena();
        assertEquals("UFC, nova arena disponivel para contato: Arena{name='Maracanãzinho', city='Rio de Janeiro', state='RJ', capacity=11800}", ufc.getLastUpdate());
        assertEquals("Bellator, nova arena disponivel para contato: Arena{name='Maracanãzinho', city='Rio de Janeiro', state='RJ', capacity=11800}", bellator.getLastUpdate());
    }

    @Test
    void naoDeveNotificarOrganizacoes() {
        Arena arena = new Arena("Maracanãzinho", "Rio de Janeiro", "RJ", 11800);
        Organization organization = new Organization("UFC");
        organization.addObserver(arena);
        assertEquals(null, organization.getLastUpdate());
    }

    @Test
    void deveNotificarMatrizOrganizacoes() {
        Arena arenaRJ = new Arena("Maracanãzinho", "Rio de Janeiro", "RJ", 11800);
        Arena arenaBA = new Arena("Fonte Nova", "Bahia", "BA", 48000);
        Organization ufc = new Organization("UFC");
        Organization bellator = new Organization("Bellator");
        ufc.addObserver(arenaRJ);
        bellator.addObserver(arenaBA);
        arenaRJ.getArena();
        assertEquals("UFC, nova arena disponivel para contato: Arena{name='Maracanãzinho', city='Rio de Janeiro', state='RJ', capacity=11800}", ufc.getLastUpdate());
        assertEquals(null, bellator.getLastUpdate());
    }


}