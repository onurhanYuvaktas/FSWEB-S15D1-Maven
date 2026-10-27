package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    // 1. Testin kullandığı constructor (2 parametreli)
    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    // 2. Normal kullanım için constructor (1 parametreli)
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact newContact) {
        // Eğer contact zaten listede varsa ekleme, false dön
        if (findContact(newContact.getName()) >= 0) {
            return false;
        }
        myContacts.add(newContact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            return false;
        }
        // Eğer yeni contact adı eskisiyle aynı değilse ve listede zaten varsa güncellenemez
        if (findContact(newContact.getName()) != -1 && findContact(newContact.getName()) != foundPosition) {
            return false;
        }

        myContacts.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            return false;
        }
        myContacts.remove(foundPosition);
        return true;
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i; // Listedeki indeksini döndürür
            }
        }
        return -1; // Bulunamazsa -1
    }

    public Contact queryContact(String contactName) {
        int position = findContact(contactName);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }

    public void printContact() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
