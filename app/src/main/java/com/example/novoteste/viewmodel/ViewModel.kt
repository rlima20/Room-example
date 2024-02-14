package com.example.novoteste.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.novoteste.dao.Dao
import com.example.novoteste.mapper.UserMapper
import com.example.novoteste.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel(
    private val dao: Dao,
) : ViewModel() {

    private val _state: MutableStateFlow<User> = MutableStateFlow(User())
    val state: StateFlow<User> = _state

    private val _listState: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
    val listState: StateFlow<List<User>> = _listState

    init {
        getAll()
    }

    private fun getAll() = viewModelScope.launch {
        dao.getAll().collect { users ->
            val listOfUsers: MutableList<User> = mutableListOf()

            users.forEach { user ->
                listOfUsers.add(UserMapper().toMap(user))
            }
            _listState.value = listOfUsers
        }
    }

    fun getById(id: Int) = viewModelScope.launch {
        dao.getById(id).collect {
            _state.value = UserMapper().toMap(it)
        }
    }

    fun insert(user: User) = viewModelScope.launch {
        dao.insert(UserMapper().toMap(user))
    }

    fun update(user: User) = viewModelScope.launch {
        dao.update(user.id, user.email, user.userName)
    }

    fun delete(user: User) = viewModelScope.launch {
        dao.delete(UserMapper().toMap(user))
    }
}
