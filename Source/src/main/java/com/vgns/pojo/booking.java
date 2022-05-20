package com.vgns.pojo;

public class booking {
        int bookId;
        String cust_name;
        int roomid;
        String checkin;
        String checkout;

        public booking(){
            String cust_name;
            int roomid;
            String checkin;
            String ceckout;
        }

        //creating constructor
        public booking(String cust_name, int roomid, String checkin, String checkout) {
            super();
            this.cust_name = cust_name;
            this.roomid = roomid;
            this.checkin = checkin;
            this.checkout= checkout; 
        }

        //getter and setter methods
        public int getbookId() {
            return bookId;
        }

        public void setbookId(Integer roonId) {
            this.bookId = bookId;
        }
        public String getcust_name() {
            return cust_name;
        }

        public void setcust_name(String cust_name) {
            this.cust_name = cust_name;
        }

        public int getroomid() {
            return roomid;
        }

        public void setroomid(int roomid) {
            this.roomid = roomid;
        }

        public String getcheckin() {
            return checkin ;
        }

        public void setAC(String checkin) {
            this.checkin = checkin;
        }

        public String getcheckout() {
            return checkout;
        }

        public void setcheckout(String checkout) {
            this.checkout = checkout;
        }

        @Override
        public String toString() {
            return "room [cust_name=" + cust_name + ", roomid=" + roomid + ", checkin="
                    + checkin + ", checkout=" + checkout + "]";
        }
}

