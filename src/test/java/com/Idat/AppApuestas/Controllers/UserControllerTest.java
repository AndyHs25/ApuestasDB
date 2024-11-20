    package com.Idat.AppApuestas.Controllers;

    import com.Idat.AppApuestas.DTO.UserDTO;
    import com.Idat.AppApuestas.Models.user;
    import com.Idat.AppApuestas.Services.UserService;

    import static org.hamcrest.Matchers.any;
    import static org.mockito.Mockito.when;
    import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


    import com.Idat.AppApuestas.Models.team;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
    import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.boot.test.mock.mockito.MockBean;
    import org.springframework.http.MediaType;
    import org.springframework.test.web.servlet.MockMvc;
    import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
    import org.springframework.transaction.annotation.Transactional;

    import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
    @AutoConfigureMockMvc
    @SpringBootTest
    @Transactional // Asegura que las transacciones se reviertan después de cada prueba.
    public class UserControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private UserService userService; // Usa la lógica real del servicio.

        // Utilidad para convertir objetos a JSON
        public static String asJsonString(final Object obj) {
            try {
                return new ObjectMapper().writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Test
        public void createUserAndAffectDatabase() throws Exception {
            UserDTO user = new UserDTO();
            user.setName("Juan");
            user.setLastName("Garcia");
            user.setDocument("23496458");
            user.setDateNac("18-08-36");
            user.setEmail("juan.garcia@gmail.com");
            user.setPassword("1234");
            user.setPhone("123456788");
            user.setAddress("Calle Falsa 123");
            user.setCity("Lima");
            user.setCard("1234123412341238");
            user.setDateCard("12/25");
            user.setCodCard("123");
            user.setCash(5566.00f);
            user.setRole("admin");

            // Crea el usuario mediante la API
            mockMvc.perform(MockMvcRequestBuilders
                            .post("/api/user")
                            .content(asJsonString(user))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isCreated());
        }

        @Test
        public void listUsers() throws Exception {
            // Listar usuarios debería devolver un status OK
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/user")
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk());
        }

        @Test
        public void deleteUserById() throws Exception {
            // Primero, crea un usuario
            UserDTO user = new UserDTO();
            user.setName("Juan");
            user.setLastName("Garcia");
            user.setDocument("23466456");
            user.setDateNac("18-08-36");
            user.setEmail("juan.garcia@gmail.com");
            user.setPassword("1234");
            user.setPhone("123456789");
            user.setAddress("Calle Falsa 123");
            user.setCity("Lima");
            user.setCard("1234123412341234");
            user.setDateCard("12/25");
            user.setCodCard("123");
            user.setCash(5566.00f);
            user.setRole("admin");

            userService.addUser(user); // Agrega el usuario a la base de datos

            // Simula la eliminación por ID
            mockMvc.perform(MockMvcRequestBuilders
                            .delete("/api/user/{id}", 1) // Asegúrate de usar un ID válido
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }

        @Test
        public void updateUser() throws Exception {

            // Actualiza los datos del usuario
            UserDTO updatedUser = new UserDTO();
            updatedUser.setName("Juan");
            updatedUser.setLastName("Garcia");
            updatedUser.setDocument("23466456");
            updatedUser.setDateNac("18-08-36");
            updatedUser.setEmail("juan.garcia@gmail.com");
            updatedUser.setPassword("1234");
            updatedUser.setPhone("123456789");
            updatedUser.setAddress("Calle Falsa 123");
            updatedUser.setCity("Lima");
            updatedUser.setCard("1234123412341234");
            updatedUser.setDateCard("12/25");
            updatedUser.setCodCard("123");
            updatedUser.setCash(5566.00f);
            updatedUser.setRole("USER");

            // Simula la actualización por ID
            mockMvc.perform(MockMvcRequestBuilders
                            .put("/api/user/edit/{id}", (long)1) // Asegúrate de usar un ID válido
                            .content(asJsonString(updatedUser))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk());
        }
    }