package ua.epam.spring.hometask.yeremenko.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

/**
 * The type User.
 *
 * @author Yuriy_Tkach
 */
@Component
@Scope("prototype")
public class User extends DomainObject {

    private String firstName;

    private String lastName;

    private String email;

    private LocalDateTime birthday;

    private boolean lucky;

    /**
     * Is lucky boolean.
     *
     * @return the boolean
     */
    public boolean isLucky() {
        return lucky;
    }

    /**
     * Sets lucky.
     *
     * @param lucky the lucky
     */
    public void setLucky(boolean lucky) {
        this.lucky = lucky;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public LocalDateTime getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    private NavigableSet<Ticket> tickets = new TreeSet<>();

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets tickets.
     *
     * @return the tickets
     */
    public NavigableSet<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Sets tickets.
     *
     * @param tickets the tickets
     */
    public void setTickets(NavigableSet<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        } else if (!lastName.equals(other.lastName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{fName='" + firstName + '\'' +
                ", lName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", tickets='" + tickets + '\'' +
                ", lucky='" + lucky + '\'' +
                '}';
    }
}
