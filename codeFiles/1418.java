public class State {            private String stateName,timeZone;        private int population;        private double density;                        //default constructor        public State()        {                    }                //constructor        public State(String theName)         {            stateName=theName;        }                //name getter+setter        public String getName()         {            return stateName;        }                public void setName(String theName)         {            stateName=theName;        }    }