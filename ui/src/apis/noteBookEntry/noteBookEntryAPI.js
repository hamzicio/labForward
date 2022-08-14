import axios from "axios";
import {
  getFrequency,
  getFrequencyWithSimilarWords,
  getSimilarWords,
  updateNoteBookEntry,
} from "../constants";

const API_URL = process.env.REACT_APP_API_URL;

export const getSimilarWord = async (word) => {
  /**
   * use activeSop as param in GET API call
   */
  return axios.get(`${API_URL}/${getSimilarWords}`, {
    params: {
      word,
    },
  });
};

export const getFrequencyOfWord = async (word) => {
  /**
   * use activeSop as param in GET API call
   */
  return axios.get(`${API_URL}/${getFrequency}`, {
    params: {
      word,
    },
  });
};

export const getFrequencyWSimilarWord = async (word) => {
  /**
   * use activeSop as param in GET API call
   */
  return axios.get(`${API_URL}/${getFrequencyWithSimilarWords}`, {
    params: {
      word,
    },
  });
};

export const updateNoteBook = async (word) => {
  /**
   * use activeSop as param in GET API call
   */
  return axios.post(`${API_URL}/${updateNoteBookEntry}`, {
    word: word,
  });
};
